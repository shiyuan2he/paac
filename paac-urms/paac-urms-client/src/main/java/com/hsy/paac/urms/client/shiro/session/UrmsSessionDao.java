package com.hsy.paac.urms.client.shiro.session;

import com.hsy.paac.base.util.RedisUtil;
import com.hsy.paac.urms.base.constant.UrmsConstant;
import com.hsy.paac.urms.client.util.SerializableUtil;
import org.apache.commons.lang.ObjectUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.urms.client.shiro.filter
 * @date 05/09/2017 9:57 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class UrmsSessionDao extends CachingSessionDAO{
    private static Logger _log = LoggerFactory.getLogger(UrmsSessionDao.class);
    // 会话key
    private final static String PAAC_URMS_SHIRO_SESSION_ID = "paac-urms-shiro-session-id";
    // 全局会话key
    private final static String PAAC_URMS_SERVER_SESSION_ID = "paac-urms-server-session-id";
    // 全局会话列表key
    private final static String PAAC_URMS_SERVER_SESSION_IDS = "paac-urms-server-session-ids";
    // code key
    private final static String PAAC_URMS_SERVER_CODE = "paac-urms-server-code";
    // 局部会话key
    private final static String PAAC_URMS_CLIENT_SESSION_ID = "paac-urms-client-session-id";
    // 单点同一个code所有局部会话key
    private final static String PAAC_URMS_CLIENT_SESSION_IDS = "paac-urms-client-session-ids";

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        RedisUtil.set(PAAC_URMS_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        _log.debug("doCreate >>>>> sessionId={}", sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String session = RedisUtil.get(PAAC_URMS_SHIRO_SESSION_ID + "_" + sessionId);
        _log.debug("doReadSession >>>>> sessionId={}", sessionId);
        return SerializableUtil.deserialize(session);
    }

    @Override
    protected void doUpdate(Session session) {
        // 如果会话过期/停止 没必要再更新了
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return;
        }
        // 更新session的最后一次访问时间
        UrmsSession upmsSession = (UrmsSession) session;
        UrmsSession cacheUpmsSession = (UrmsSession) doReadSession(session.getId());
        if (null != cacheUpmsSession) {
            upmsSession.setStatus(cacheUpmsSession.getStatus());
            upmsSession.setAttribute("FORCE_LOGOUT", cacheUpmsSession.getAttribute("FORCE_LOGOUT"));
        }
        RedisUtil.set(PAAC_URMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        // 更新PAAC_URMS_SERVER_SESSION_ID、PAAC_URMS_SERVER_CODE过期时间 TODO
        _log.debug("doUpdate >>>>> sessionId={}", session.getId());
    }

    @Override
    protected void doDelete(Session session) {
        String sessionId = session.getId().toString();
        String upmsType = ObjectUtils.toString(session.getAttribute(UrmsConstant.UPMS_TYPE));
        if ("client".equals(upmsType)) {
            // 删除局部会话和同一code注册的局部会话
            String code = RedisUtil.get(PAAC_URMS_CLIENT_SESSION_ID + "_" + sessionId);
            Jedis jedis = RedisUtil.getJedis();
            jedis.del(PAAC_URMS_CLIENT_SESSION_ID + "_" + sessionId);
            jedis.srem(PAAC_URMS_CLIENT_SESSION_IDS + "_" + code, sessionId);
            jedis.close();
        }
        if ("server".equals(upmsType)) {
            // 当前全局会话code
            String code = RedisUtil.get(PAAC_URMS_SERVER_SESSION_ID + "_" + sessionId);
            // 清除全局会话
            RedisUtil.remove(PAAC_URMS_SERVER_SESSION_ID + "_" + sessionId);
            // 清除code校验值
            RedisUtil.remove(PAAC_URMS_SERVER_CODE + "_" + code);
            // 清除所有局部会话
            Jedis jedis = RedisUtil.getJedis();
            Set<String> clientSessionIds = jedis.smembers(PAAC_URMS_CLIENT_SESSION_IDS + "_" + code);
            for (String clientSessionId : clientSessionIds) {
                jedis.del(PAAC_URMS_CLIENT_SESSION_ID + "_" + clientSessionId);
                jedis.srem(PAAC_URMS_CLIENT_SESSION_IDS + "_" + code, clientSessionId);
            }
            _log.debug("当前code={}，对应的注册系统个数：{}个", code, jedis.scard(PAAC_URMS_CLIENT_SESSION_IDS + "_" + code));
            jedis.close();
            // 维护会话id列表，提供会话分页管理
            RedisUtil.lrem(PAAC_URMS_SERVER_SESSION_IDS, 1, sessionId);
        }
        // 删除session
        RedisUtil.remove(PAAC_URMS_SHIRO_SESSION_ID + "_" + sessionId);
        _log.debug("doUpdate >>>>> sessionId={}", sessionId);
    }

    /**
     * 获取会话列表
     * @param offset
     * @param limit
     * @return
     */
    public Map getActiveSessions(int offset, int limit) {
        Map sessions = new HashMap();
        Jedis jedis = RedisUtil.getJedis();
        // 获取在线会话总数
        long total = jedis.llen(PAAC_URMS_SERVER_SESSION_IDS);
        // 获取当前页会话详情
        List<String> ids = jedis.lrange(PAAC_URMS_SERVER_SESSION_IDS, offset, (offset + limit - 1));
        List<Session> rows = new ArrayList<>();
        for (String id : ids) {
            String session = RedisUtil.get(PAAC_URMS_SHIRO_SESSION_ID + "_" + id);
            // 过滤redis过期session
            if (null == session) {
                RedisUtil.lrem(PAAC_URMS_SERVER_SESSION_IDS, 1, id);
                total = total - 1;
                continue;
            }
            rows.add(SerializableUtil.deserialize(session));
        }
        jedis.close();
        sessions.put("total", total);
        sessions.put("rows", rows);
        return sessions;
    }

    /**
     * 强制退出
     * @param ids
     * @return
     */
    public int forceout(String ids) {
        String[] sessionIds = ids.split(",");
        for (String sessionId : sessionIds) {
            // 会话增加强制退出属性标识，当此会话访问系统时，判断有该标识，则退出登录
            String session = RedisUtil.get(PAAC_URMS_SHIRO_SESSION_ID + "_" + sessionId);
            UrmsSession upmsSession = (UrmsSession) SerializableUtil.deserialize(session);
            upmsSession.setStatus(UrmsSession.OnlineStatus.force_logout);
            upmsSession.setAttribute("FORCE_LOGOUT", "FORCE_LOGOUT");
            RedisUtil.set(PAAC_URMS_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(upmsSession), (int) upmsSession.getTimeout() / 1000);
        }
        return sessionIds.length;
    }

    /**
     * 更改在线状态
     *
     * @param sessionId
     * @param onlineStatus
     */
    public void updateStatus(Serializable sessionId, UrmsSession.OnlineStatus onlineStatus) {
        UrmsSession session = (UrmsSession) doReadSession(sessionId);
        if (null == session) {
            return;
        }
        session.setStatus(onlineStatus);
        RedisUtil.set(PAAC_URMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
    }
}
