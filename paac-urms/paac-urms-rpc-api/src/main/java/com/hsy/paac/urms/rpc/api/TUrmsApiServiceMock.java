package com.hsy.paac.urms.rpc.api;

import com.zheng.upms.dao.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 降级实现UpmsApiService接口
 * Created by shuzheng on 2017/2/14.
 */
public class TUrmsApiServiceMock implements TUrmsApiService {

    private static Logger _log = LoggerFactory.getLogger(TUrmsApiServiceMock.class);

    @Override
    public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectUpmsPermissionByUpmsUserId");
        return null;
    }

    @Override
    public List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectUpmsPermissionByUpmsUserIdByCache");
        return null;
    }

    @Override
    public List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectUpmsRoleByUpmsUserId");
        return null;
    }

    @Override
    public List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectUpmsRoleByUpmsUserIdByCache");
        return null;
    }

    @Override
    public List<UpmsRolePermission> selectUpmsRolePermisstionByUpmsRoleId(Integer upmsRoleId) {
        _log.info("TUrmsApiServiceMock => selectUpmsRolePermisstionByUpmsRoleId");
        return null;
    }

    @Override
    public List<UpmsUserPermission> selectUpmsUserPermissionByUpmsUserId(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectUpmsUserPermissionByUpmsUserId");
        return null;
    }

    @Override
    public List<UpmsSystem> selectUpmsSystemByExample(UpmsSystemExample upmsSystemExample) {
        _log.info("TUrmsApiServiceMock => selectUpmsSystemByExample");
        return null;
    }

    @Override
    public List<UpmsOrganization> selectUpmsOrganizationByExample(UpmsOrganizationExample upmsOrganizationExample) {
        _log.info("TUrmsApiServiceMock => selectUpmsOrganizationByExample");
        return null;
    }

    @Override
    public UpmsUser selectUpmsUserByUsername(String username) {
        _log.info("TUrmsApiServiceMock => selectUpmsUserByUsername");
        return null;
    }

    @Override
    public int insertUpmsLogSelective(UpmsLog record) {
        _log.info("TUrmsApiServiceMock => insertSelective");
        return 0;
    }

}
