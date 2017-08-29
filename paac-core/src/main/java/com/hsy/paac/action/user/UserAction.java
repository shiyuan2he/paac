package com.hsy.paac.action.user;


import com.hsy.paac.service.user.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hsy.paac.entry.hibernate.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @description <p>处理用户相关逻辑</p>
 * @path paac-core/com.codelibrary.javaee.action.base.BaseAction.java	
 * @time 2016年5月15日 上午10:14:59
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Controller
public class UserAction extends ActionSupport{
	private static Logger _logger = Logger.getLogger(UserAction.class);
	private static final long serialVersionUID = 1L;
	private User user ;
	private String tip ;
	@SuppressWarnings("unused")
	@Autowired
	private IUserService userService ;
	/**
	 * 
	 * @return
	 * @returnType String
	 * @description 
	 *		<p>跳转到登陆页面</p>
	 */
	public String to_login_login(){
		_logger.info("跳转到用户登录页面。。");
		return "toView";
	}
	/**
	 * 
	 * @return
	 * @returnType String
	 * @description 
	 *		<p>跳转到用户注册页面</p>
	 */
	public String to_login_register(){
		_logger.info("跳转到用户注册页面。。");
		return "toView" ;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

