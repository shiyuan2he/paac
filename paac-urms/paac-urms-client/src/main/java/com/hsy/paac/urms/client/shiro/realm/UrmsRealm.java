package com.hsy.paac.urms.client.shiro.realm;

import com.hsy.paac.base.util.MD5Util;
import com.hsy.paac.base.util.PropertiesFileUtil;
import com.hsy.paac.urms.base.model.TUrmsPermission;
import com.hsy.paac.urms.base.model.TUrmsRole;
import com.hsy.paac.urms.base.model.TUrmsUser;
import com.hsy.paac.urms.rpc.api.TUrmsApiService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.urms.client.shiro.realm
 * @date 05/09/2017 10:40 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class UrmsRealm extends AuthorizingRealm {

    @Autowired
    private TUrmsApiService urmsApiService;

    /**
     * 授权：验证权限时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        TUrmsUser urmsUser = urmsApiService.selectTUrmsUserByTUsername(username);

        // 当前用户所有角色
        List<TUrmsRole> upmsRoles = urmsApiService.selectTUrmsRoleByUrmsUserId(urmsUser.getUserId());
        Set<String> roles = new HashSet<>();
        for (TUrmsRole upmsRole : upmsRoles) {
            if (StringUtils.isNotBlank(upmsRole.getName())) {
                roles.add(upmsRole.getName());
            }
        }

        // 当前用户所有权限
        List<TUrmsPermission> urmsPermissions = urmsApiService.selectTUrmsPermissionByTUrmsUserId(urmsUser.getUserId());
        Set<String> permissions = new HashSet<>();
        for (TUrmsPermission urmsPermission : urmsPermissions) {
            if (StringUtils.isNotBlank(urmsPermission.getPermissionValue())) {
                permissions.add(urmsPermission.getPermissionValue());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证：登录时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        // client无密认证
        String upmsType = PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.type");
        if ("client".equals(upmsType)) {
            return new SimpleAuthenticationInfo(username, password, getName());
        }

        // 查询用户信息
        TUrmsUser upmsUser = urmsApiService.selectTUrmsUserByTUsername(username);

        if (null == upmsUser) {
            throw new UnknownAccountException();
        }
        if (!upmsUser.getPassword().equals(MD5Util.MD5(password + upmsUser.getSalt()))) {
            throw new IncorrectCredentialsException();
        }
        if (upmsUser.getLocked() == 1) {
            throw new LockedAccountException();
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
