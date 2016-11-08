
package com.codelibrary.javaee.action.base;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
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
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware,ServletContextAware{
	/**
	 * @description <p>请再次输入属性描述</p>
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static Logger _logger = Logger.getLogger(BaseAction.class);
	protected HttpServletRequest request ;
	protected HttpServletResponse response ;
	protected HttpSession httpSession ;
	protected Map<String, Object> mapSession;
	protected Map<String, Object> mapSessionOfActionContext ;
	protected ServletContext application ;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request ;
		this.httpSession = request.getSession() ;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response ;
	}
	public void setSession(Map<String, Object> session) {
		this.mapSession = session ;
	}
	public void setServletContext(ServletContext application) {
		this.application = application ; 
	}
}

