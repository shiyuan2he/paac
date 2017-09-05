package com.hsy.paac.urms.rpc.api;

import com.hsy.paac.urms.base.model.*;
import java.util.List;

/**
 * upms系统接口
 * Created by shuzheng on 2017/2/11.
 */
public interface TUrmsApiService {

    /**
     * 根据用户id获取所拥有的权限(用户和角色权限合集)
     * @param upmsUserId
     * @return
     */
    List<TUrmsPermission> selectTUrmsPermissionByTUrmsUserId(Integer upmsUserId);

    /**
     * 根据用户id获取所拥有的权限(用户和角色权限合集)
     * @param upmsUserId
     * @return
     */
    List<TUrmsPermission> selectTUrmsPermissionByTUrpmsUserIdByCache(Integer upmsUserId);

    /**
     * 根据用户id获取所属的角色
     * @param upmsUserId
     * @return
     */
    List<TUrmsRole> selectTUrmsRoleByUrmsUserId(Integer upmsUserId);

    /**
     * 根据用户id获取所属的角色
     * @param upmsUserId
     * @return
     */
    List<TUrmsRole> selectTUrmsRoleByUpmsUserIdByCache(Integer upmsUserId);

    /**
     * 根据角色id获取所拥有的权限
     * @param upmsRoleId
     * @return
     */
    List<TUrmsRolePermission> selectTUrmsRolePermisstionByTUrmsRoleId(Integer upmsRoleId);

    /**
     * 根据用户id获取所拥有的权限
     * @param upmsUserId
     * @return
     */
    List<TUrmsUserPermission> selectTUrmsUserPermissionByTUrmsUserId(Integer upmsUserId);

    /**
     * 根据条件获取系统数据
     * @param upmsSystemExample
     * @return
     */
    List<TUrmsSystem> selectTUrmsSystemByExample(TUrmsSystemExample upmsSystemExample);

    /**
     * 根据条件获取组织数据
     * @param upmsOrganizationExample
     * @return
     */
    List<TUrmsOrganization> selectTUrmsOrganizationByExample(TUrmsOrganizationExample upmsOrganizationExample);

    /**
     * 根据username获取UpmsUser
     * @param username
     * @return
     */
    TUrmsUser selectTUrmsUserByTUsername(String username);

    /**
     * 写入操作日志
     * @param record
     * @return
     */
    int insertUpmsLogSelective(TUrmsLog record);

}
