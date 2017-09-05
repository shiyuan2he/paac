package com.hsy.paac.urms.rpc.service.impl;

import com.hsy.paac.base.annotation.BaseService;
import com.hsy.paac.base.common.BaseServiceImpl;
import com.hsy.paac.urms.dao.mapper.TUrmsLogMapper;
import com.hsy.paac.urms.base.model.TUrmsLog;
import com.hsy.paac.urms.base.model.TUrmsLogExample;
import com.hsy.paac.urms.rpc.api.TUrmsLogService;
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
public class TUrmsLogServiceImpl extends BaseServiceImpl<TUrmsLogMapper, TUrmsLog, TUrmsLogExample> implements TUrmsLogService {

    private static Logger _logger = LoggerFactory.getLogger(TUrmsLogServiceImpl.class);

    @Autowired
    TUrmsLogMapper tUrmsLogMapper;

}