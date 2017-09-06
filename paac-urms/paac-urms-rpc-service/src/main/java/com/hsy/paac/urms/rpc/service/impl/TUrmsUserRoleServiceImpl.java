package com.hsy.paac.urms.rpc.service.impl;

import com.hsy.paac.base.annotation.BaseService;
import com.hsy.paac.base.common.BaseServiceImpl;
import com.hsy.paac.urms.base.model.TUrmsUserRole;
import com.hsy.paac.urms.base.model.TUrmsUserRoleExample;
import com.hsy.paac.urms.rpc.api.TUrmsUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @description <p></p>
 * @author heshiyuan
 * @date 2017/09/05
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Service
@Transactional
@BaseService
public class TUrmsUserRoleServiceImpl extends BaseServiceImpl<TUrmsUserRoleMapper, TUrmsUserRole, TUrmsUserRoleExample> implements TUrmsUserRoleService {

    private static Logger _logger = LoggerFactory.getLogger(TUrmsUserRoleServiceImpl.class);

    @Autowired
    TUrmsUserRoleMapper tUrmsUserRoleMapper;

}