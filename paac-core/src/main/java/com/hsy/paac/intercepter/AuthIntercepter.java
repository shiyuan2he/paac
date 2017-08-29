package com.hsy.paac.intercepter;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @description <p>用户登录权限验证</p>
 * @path paac-core/com.codelibrary.javaee.intercepter.AuthIntercepter.java	
 * @time 2016年5月29日 下午9:03:04
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * @price $：三毛三 如有捐赠，请联系我。邮箱：shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class AuthIntercepter extends AbstractInterceptor {
	//private static LoggerEx logger = LoggerEx.getInstance(AuthIntercepter.class.getName()) ;
	private static Logger logger = Logger.getLogger(AuthIntercepter.class) ;
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession() ;
		//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		// 此处添加所拦截的地址并输出来
		
		// 已登陆，放行此次请求
		if(null != session.get("user")){
			logger.info("AuthIntercepter：用户已登陆，此次请求放行");
			return invocation.invoke() ;
		}else{
			// 未登录，跳转到登陆页面
			logger.warn("AuthIntercepter：用户未登陆，跳转到登陆页面");
			return "toLoginView" ;
		}
	}
}

