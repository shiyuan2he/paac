package com.hsy.paac.urms.rpc.service.impl;

import com.hsy.paac.base.annotation.BaseService;
import com.hsy.paac.base.common.BaseServiceImpl;
import com.hsy.paac.urms.dao.mapper.TUrmsUserPermissionMapper;
import com.hsy.paac.urms.base.model.TUrmsUserPermission;
import com.hsy.paac.urms.base.model.TUrmsUserPermissionExample;
import com.hsy.paac.urms.rpc.api.TUrmsUserPermissionService;
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
public class TUrmsUserPermissionServiceImpl extends BaseServiceImpl<TUrmsUserPermissionMapper, TUrmsUserPermission, TUrmsUserPermissionExample> implements TUrmsUserPermissionService {

    private static Logger _logger = LoggerFactory.getLogger(TUrmsUserPermissionServiceImpl.class);

    @Autowired
    TUrmsUserPermissionMapper tUrmsUserPermissionMapper;

}