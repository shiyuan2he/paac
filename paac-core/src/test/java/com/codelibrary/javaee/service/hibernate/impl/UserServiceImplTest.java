package com.codelibrary.javaee.service.hibernate.impl;

import java.sql.SQLException;

import org.junit.Test;

import com.codelibrary.javaee.UnitTestBaseSpring;
import com.codelibrary.javaee.entry.jdbc.User;
import com.codelibrary.javaee.service.IUserService;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path paac-core/com.codelibrary.javaee.service.hibernate.impl.UserServiceImplTest.java	
 * @time 2016年6月17日 下午1:29:00
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class UserServiceImplTest extends UnitTestBaseSpring{

	@Test
	public void testLogin(){
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
//			UserDao userDao = super.getBean("userService");
//			userDao.saveUser(user);
	}
	@Test
	public void testAddUser() throws SQLException{
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
//		IUserService userService = super.getBean("userService");
	}
}

