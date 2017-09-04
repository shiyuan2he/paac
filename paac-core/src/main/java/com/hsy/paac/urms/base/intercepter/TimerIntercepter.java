package com.hsy.paac.urms.base.intercepter;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @description <p>计算执行action所花费的时间</p>
 * @path paac-core/com.codelibrary.javaee.intercepter.TimerIntercepter.java	
 * @time 2016年5月29日 下午8:45:50
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class TimerIntercepter extends AbstractInterceptor {
	private static Logger logger = Logger.getLogger(TimerIntercepter.class) ;
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//当前进入此拦截器时的时间
		long start = System.currentTimeMillis() ;
		logger.info("进入时间拦截器："+start+"毫秒");
		//拦截下一个拦截器，如果已经是最后一个拦截器，则执行目标action
		String result = invocation.invoke() ;
		//执行完action后的事件
		long end = System.currentTimeMillis() ;
		logger.info("退出时间拦截器："+start+"毫秒");
		logger.info("时间拦截器：执行此action所花费的时间："+(end-start)+"毫秒");
		return result;
	}
}

