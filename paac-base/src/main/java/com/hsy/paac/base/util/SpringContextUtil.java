package com.hsy.paac.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

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
    private static ApplicationContext context = null;

    private SpringContextUtil() {
        super();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 根据名称获取bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    /**
     * 根据bean名称获取指定类型bean
     * @param beanName bean名称
     * @param clazz 返回的bean类型,若类型不匹配,将抛出异常
     */
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return context.getBean(beanName, clazz);
    }
    /**
     * 根据类型获取bean
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        T t = null;
        Map<String, T> map = context.getBeansOfType(clazz);
        for (Map.Entry<String, T> entry : map.entrySet()) {
            t = entry.getValue();
        }
        return t;
    }

    /**
     * 是否包含bean
     * @param beanName
     * @return
     */
    public static boolean containsBean(String beanName) {
        return context.containsBean(beanName);
    }

    /**
     * 是否是单例
     * @param beanName
     * @return
     */
    public static boolean isSingleton(String beanName) {
        return context.isSingleton(beanName);
    }

    /**
     * bean的类型
     * @param beanName
     * @return
     */
    public static Class getType(String beanName) {
        return context.getType(beanName);
    }
}
