package com.hsy.paac.urms.client.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @description <p></p>
 * @author heshiyuan
 * @date 06/09/2017 8:49 AM
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class UrmsSessionListener implements SessionListener {

    private static Logger _log = LoggerFactory.getLogger(UrmsSessionListener.class);

    @Override
    public void onStart(Session session) {
        _log.debug("会话创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        _log.debug("会话停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        _log.debug("会话过期：" + session.getId());
    }

}
