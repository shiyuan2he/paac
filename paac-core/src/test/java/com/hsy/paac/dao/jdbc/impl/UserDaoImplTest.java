/**
 * @path paac-core/com.codelibrary.javaee.dao.jdbc.impl/UserDaoImplTest.java	
 * @time May 1, 2016 11:50:13 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.hsy.paac.dao.jdbc.impl;

import com.hsy.paac.UnitTestBaseSpring;
import com.hsy.paac.entry.jdbc.User;
import org.junit.Test;

public class UserDaoImplTest extends UnitTestBaseSpring {
	public UserDaoImplTest(){
		super("classpath:spring/applicationContext.xml") ;
	}
	
	@Test
	public void testSaveUser(){
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
//			UserDao userDao = super.getBean("userDao");
//			userDao.saveUser(user);
	}
	@Test
	public void testFindUser(){
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
//			UserDao userDao = super.getBean("userDao");
//			userDao.findUser(user) ;
	}
}

