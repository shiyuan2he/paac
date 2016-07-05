/**
 * @path paac-core/com.codelibrary.javaee.dao.jdbc.impl/UserDaoImplTest.java	
 * @time May 1, 2016 11:50:13 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.dao.jdbc.impl;

import java.sql.SQLException;
import org.junit.Test;

import com.codelibrary.javaee.UnitTestBaseSpring;
import com.codelibrary.javaee.dao.jdbc.UserDao;
import com.codelibrary.javaee.entry.jdbc.User;

public class UserDaoImplTest extends UnitTestBaseSpring{
	public UserDaoImplTest(){
		super("classpath:spring/applicationContext.xml") ;
	}
	
	@Test
	public void testSaveUser(){
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
		try {
			UserDao userDao = super.getBean("userDao");
			userDao.saveUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testFindUser(){
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
		try {
			UserDao userDao = super.getBean("userDao");
			userDao.findUser(user) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

