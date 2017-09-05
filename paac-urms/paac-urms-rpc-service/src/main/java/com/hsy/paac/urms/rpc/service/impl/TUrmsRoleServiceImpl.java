package com.hsy.paac.urms.rpc.service.impl;

import com.hsy.paac.base.annotation.BaseService;
import com.hsy.paac.base.common.BaseServiceImpl;
import com.hsy.paac.urms.dao.mapper.TUrmsRoleMapper;
import com.hsy.paac.urms.base.model.TUrmsRole;
import com.hsy.paac.urms.base.model.TUrmsRoleExample;
import com.hsy.paac.urms.rpc.api.TUrmsRoleService;
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
public class TUrmsRoleServiceImpl extends BaseServiceImpl<TUrmsRoleMapper, TUrmsRole, TUrmsRoleExample> implements TUrmsRoleService {

    private static Logger _logger = LoggerFactory.getLogger(TUrmsRoleServiceImpl.class);

    @Autowired
    TUrmsRoleMapper tUrmsRoleMapper;

}