
package com.hsy.paac.urms.base.action.base;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @description <p>action基类，封装request，response，session，application等信息
 * 					ActionContext也能够获取到httpservletrequest等信息。
 * 				</p>
 * @path paac-core/com.codelibrary.javaee.action.base.BaseAction.java	
 * @time 2016年5月15日 上午10:14:59
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Controller
public class BaseAction extends ActionSupport{
	/**
	 * @description <p>请再次输入属性描述</p>
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static Logger _logger = Logger.getLogger(BaseAction.class);
	protected static HttpServletRequest request ;
	protected static HttpServletResponse response ;
	protected static HttpSession httpSession ;
	protected static Map<String, Object> mapSession;
	protected static ServletContext application ;
	
	/*static{
		request = ServletActionContext.getRequest() ;
		response = ServletActionContext.getResponse() ;
		mapSession = ActionContext.getContext().getSession() ;
		application = (ServletContext)  ActionContext.getContext().getApplication() ;
	}*/
}

