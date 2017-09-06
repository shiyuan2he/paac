package com.hsy.paac.urms.rpc.service.impl;

import com.hsy.paac.urms.base.model.*;
import com.hsy.paac.urms.dao.mapper.*;
import com.hsy.paac.urms.rpc.api.TUrmsApiService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UpmsApiService实现
 * Created by shuzheng on 2016/01/19.
 */
@Service
@Transactional
public class TUrmsApiServiceImpl implements TUrmsApiService {

    private static Logger _log = Logger.getLogger(TUrmsApiServiceImpl.class);

    @Autowired
    TUrmsUserMapper urmsUserMapper;

    @Autowired
    TUrmsApiMapper urmsApiMapper;

    @Autowired
    TUrmsRolePermissionMapper urmsRolePermissionMapper;

    @Autowired
    TUrmsUserPermissionMapper urmsUserPermissionMapper;

    @Autowired
    TUrmsSystemMapper urmsSystemMapper;

    @Autowired
    TUrmsOrganizationMapper urmsOrganizationMapper;

    @Autowired
    TUrmsLogMapper urmsLogMapper;

    /**
     * 根据用户id获取所拥有的权限
     * @param upmsUserId
     * @return
     */
    @Override
    public List<TUrmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId) {
        // 用户不存在或锁定状态
        TUrmsUser upmsUser = urmsUserMapper.selectByPrimaryKey(upmsUserId);
        if (null == upmsUser || 1 == upmsUser.getLocked()) {
            _log.info("selectUpmsPermissionByUpmsUserId : upmsUserId={}", upmsUserId);
            return null;
        }
        List<TUrmsPermission> upmsPermissions = urmsApiMapper.selectTUrmsPermissionByUrmsUserId(upmsUserId);
        return upmsPermissions;
    }

    /**
     * 根据用户id获取所拥有的权限
     * @param upmsUserId
     * @return
     */
    @Override
    @Cacheable(value = "zheng-upms-rpc-service-ehcache", key = "'selectUpmsPermissionByUpmsUserId_' + #upmsUserId")
    public List<TUrmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId) {
        return selectUpmsPermissionByUpmsUserId(upmsUserId);
    }

    /**
     * 根据用户id获取所属的角色
     * @param upmsUserId
     * @return
     */
    @Override
    public List<TUrmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
        // 用户不存在或锁定状态
        TUrmsUser upmsUser = urmsUserMapper.selectByPrimaryKey(upmsUserId);
        if (null == upmsUser || 1 == upmsUser.getLocked()) {
            _log.info("selectUpmsRoleByUpmsUserId : upmsUserId={}", upmsUserId);
            return null;
        }
        List<TUrmsRole> upmsRoles = urmsApiMapper.selectUpmsRoleByUpmsUserId(upmsUserId);
        return upmsRoles;
    }

    /**
     * 根据用户id获取所属的角色
     * @param upmsUserId
     * @return
     */
    @Override
    @Cacheable(value = "zheng-upms-rpc-service-ehcache", key = "'selectUpmsRoleByUpmsUserId_' + #upmsUserId")
    public List<TUrmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer urmsUserId) {
        return selectUpmsRoleByUpmsUserId(urmsUserId);
    }

    /**
     * 根据角色id获取所拥有的权限
     * @param upmsRoleId
     * @return
     */
    @Override
    public List<TUrmsRolePermission> selectUpmsRolePermisstionByUpmsRoleId(Integer urmsRoleId) {
        TUrmsRolePermissionExample urmsRolePermissionExample = new TUrmsRolePermissionExample();
        urmsRolePermissionExample.createCriteria()
                .andRoleIdEqualTo(urmsRoleId);
        List<TUrmsRolePermission> urmsRolePermissions = urmsRolePermissionMapper.selectByExample(urmsRolePermissionExample);
        return urmsRolePermissions;
    }

    /**
     * 根据用户id获取所拥有的权限
     * @param upmsUserId
     * @return
     */
    @Override
    public List<TUrmsUserPermission> selectUpmsUserPermissionByUpmsUserId(Integer urmsUserId) {
        TUrmsUserPermissionExample urmsUserPermissionExample = new TUrmsUserPermissionExample();
        urmsUserPermissionExample.createCriteria()
                .andUserIdEqualTo(urmsUserId);
        List<TUrmsUserPermission> urmsUserPermissions = urmsUserPermissionMapper.selectByExample(urmsUserPermissionExample);
        return urmsUserPermissions;
    }

    /**
     * 根据条件获取系统数据
     * @param upmsSystemExample
     * @return
     */
    @Override
    public List<TUrmsSystem> selectUpmsSystemByExample(TUrmsSystemExample urmsSystemExample) {
        return urmsSystemMapper.selectByExample(urmsSystemExample);
    }

    /**
     * 根据条件获取组织数据
     * @param upmsOrganizationExample
     * @return
     */
    @Override
    public List<TUrmsOrganization> selectUpmsOrganizationByExample(TUrmsOrganizationExample urmsOrganizationExample) {
        return urmsOrganizationMapper.selectByExample(urmsOrganizationExample);
    }

    /**
     * 根据username获取UpmsUser
     * @param username
     * @return
     */
    @Override
    public TUrmsUser selectUpmsUserByUsername(String username) {
        TUrmsUserExample urmsUserExample = new TUrmsUserExample();
        urmsUserExample.createCriteria()
                .andUsernameEqualTo(username);
        List<TUrmsUser> upmsUsers = urmsUserMapper.selectByExample(urmsUserExample);
        if (null != upmsUsers && upmsUsers.size() > 0) {
            return upmsUsers.get(0);
        }
        return null;
    }

    /**
     * 写入操作日志
     * @param record
     * @return
     */
    @Override
    public int insertUpmsLogSelective(TUrmsLog record) {
        return urmsLogMapper.insertSelective(record);
    }

}