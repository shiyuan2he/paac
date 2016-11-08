package com.codelibrary.javaee.action.user;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codelibrary.javaee.action.base.BaseAction;
import com.codelibrary.javaee.entry.hibernate.User;
import com.codelibrary.javaee.service.user.IUserService;

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
public class UserAction extends BaseAction{
	private static Logger _logger = Logger.getLogger(UserAction.class);
	private static final long serialVersionUID = 1L;
	private User user ;
	private String tip ;
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

