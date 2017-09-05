package com.hsy.paac.urms.rpc.api;

import com.hsy.paac.urms.base.model.*;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * 降级实现UpmsApiService接口
 * Created by shuzheng on 2017/2/14.
 */
public class TUrmsApiServiceMock implements TUrmsApiService {

    private static Logger _log = Logger.getLogger(TUrmsApiServiceMock.class);

    @Override
    public List<TUrmsPermission> selectTUrmsPermissionByTUrmsUserId(Integer upmsUserId) {
        return null;
    }

    @Override
    public List<TUrmsPermission> selectTUrmsPermissionByTUrpmsUserIdByCache(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectTUrmsPermissionByUpmsUserIdByCache");
        return null;
    }

    @Override
    public List<TUrmsRole> selectTUrmsRoleByUrmsUserId(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectTUrmsRoleByUpmsUserId");
        return null;
    }

    @Override
    public List<TUrmsRole> selectTUrmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectTUrmsRoleByUpmsUserIdByCache");
        return null;
    }

    @Override
    public List<TUrmsRolePermission> selectTUrmsRolePermisstionByTUrmsRoleId(Integer upmsRoleId) {
        _log.info("TUrmsApiServiceMock => selectTUrmsRolePermisstionByTUrmsRoleId");
        return null;
    }

    @Override
    public List<TUrmsUserPermission> selectTUrmsUserPermissionByTUrmsUserId(Integer upmsUserId) {
        _log.info("TUrmsApiServiceMock => selectTUrmsPermissionByUpmsUserId");
        return null;
    }

    @Override
    public List<TUrmsSystem> selectTUrmsSystemByExample(TUrmsSystemExample upmsSystemExample) {
        _log.info("TUrmsApiServiceMock => selectUpmsSystemByExample");
        return null;
    }

    @Override
    public List<TUrmsOrganization> selectTUrmsOrganizationByExample(TUrmsOrganizationExample upmsOrganizationExample) {
        _log.info("TUrmsApiServiceMock => selectUpmsOrganizationByExample");
        return null;
    }

    @Override
    public TUrmsUser selectTUrmsUserByTUsername(String username) {
        return null;
    }
    @Override
    public int insertUpmsLogSelective(TUrmsLog record) {
        _log.info("TUrmsApiServiceMock => insertSelective");
        return 0;
    }

}
