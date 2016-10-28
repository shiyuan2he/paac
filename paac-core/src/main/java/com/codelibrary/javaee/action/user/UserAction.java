package com.codelibrary.javaee.action.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codelibrary.javaee.action.base.BaseAction;
import com.codelibrary.javaee.annotation.MethodException;
import com.codelibrary.javaee.entry.hibernate.User;
import com.codelibrary.javaee.service.IUserService;
import com.hsy.codebase.utils.javase.bean.BeanHelper;
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
@Controller
public class UserAction extends BaseAction implements ModelDriven<User>{
	private static Logger _logger = Logger.getLogger(UserAction.class);
	private static final long serialVersionUID = 1L;
	private User user ;
	@Autowired
	private IUserService userService ;
	/**
	 * 
	 * @return
	 * @returnType String
	 * @description
	 *		<p>用户登录</p>
	 */
	@MethodException(remark="select",description="用户登陆")
	public String do_login(){
		if(BeanHelper.isNotNull(user)&&StringHelper.isNotNullOrEmpty(user.getPassword())&&StringHelper.isNotNullOrEmpty(user.getPassword())){
			if(userService.login(user.getUsername(),user.getPassword())){
				return "login_ok" ;
			}
		}else{
			_logger.error("【--用户登录--】传递参数失败：用户名或者用户密码传递失败。。");
		}
		return "failure" ;
	}
	/**
	 * 
	 * @description <p>注册</p>
	 * @return
	 * @returnType String
	 * 方法名:do_register
	 * 类名:UserAction
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月27日 下午1:22:22
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	@MethodException(remark="add",description="用户注册")
	public String do_register(){
		try{
			if(!BeanHelper.isNull(userService)){
				boolean flag = userService.register(user.getUsername(),user.getPassword()) ;
				if(flag){
					return "register_ok" ;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
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
	@Override
	public User getModel() {
		if(user == null){
			user = new User() ;
		}
		return user;
	}
}

