package com.codelibrary.javaee.action.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.codelibrary.javaee.action.base.BaseAction;
import com.codelibrary.javaee.entry.hibernate.User;
import com.codelibrary.javaee.service.IUserService;
import com.opensymphony.xwork2.ModelDriven;

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
public class UserAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user ;
	@Autowired
	@Qualifier("userService")
	private IUserService userService ;
	/**
	 * 
	 * @return
	 * @returnType String
	 * @description 
	 *		<p>用户登录</p>
	 */
	public String do_login(){
		if(user != null){
			if(userService.login(user)){
				super.mapSession.put("user", user) ;
				return "login_ok" ;
			}
		}
		return "failure" ;
	}
	public String do_register(){
		boolean flag = userService.register(user) ;
		if(flag){
			return "register_ok" ;
		}
		return "failure" ;
	}
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
	
	public String toMain(){
		return "toMain" ;
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
	public User getModel() {
		if(user == null){
			user = new User() ;
		}
		return user;
	}
}

