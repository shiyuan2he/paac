package com.hsy.paac.urms.interceptor;

import com.hsy.paac.base.common.BaseInterface;

import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.interceptor
 * @date 01/09/2017 9:47 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class Initialize implements BaseInterface {
    private static final Logger _logger = Logger.getLogger(Initialize.class.getName()) ;
    @Override
    public void init() {
        _logger.info("系统正在初始化。。。");
    }
}
