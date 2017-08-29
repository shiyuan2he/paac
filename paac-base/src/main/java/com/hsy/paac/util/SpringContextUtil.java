package com.hsy.paac.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author heshiyuan
 * @description <p>资源文件读取工具</p>
 * @path paac/com.hsy.paac.util
 * @date 29/08/2017 1:33 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SpringContextUtil implements ApplicationContextAware{
    private static ApplicationContext context = null ;

    private SpringContextUtil(){super();}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext ;
    }
}
