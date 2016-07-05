package com.codelibrary.javaee.action.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.codelibrary.javaee.action.base.BaseAction;
import com.codelibrary.javaee.entry.hibernate.User;
import com.hsy.codebase.utils.javase.string.StringHelper;
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

public class UserAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user ;
	@Autowired
	//private UserService userService ;
	/**
	 * 
	 * @return
	 * @returnType String
	 * @description 
	 *		<p>用户登录</p>
	 */
	public String login(){
		if(user != null){
			super.mapSession.put("user", user) ;
			//userService.login(user) ;
		}
		return "login_ok" ;
	}
	/**
	 * 
	 * @return
	 * @returnType String
	 * @description 
	 *		<p>跳转到登陆页面</p>
	 */
	public String toLoginView(){
		return "toLoginView" ;
	}
	/**
	 * 
	 * @return
	 * @returnType String
	 * @description 
	 *		<p>跳转到添加用户页面</p>
	 */
	public String toRegisterView(){
		return "toRegisterView" ;
	}
	@Override
	public User getModel() {
		if(user == null){
			user = new User() ;
		}
		return user;
	}
}

