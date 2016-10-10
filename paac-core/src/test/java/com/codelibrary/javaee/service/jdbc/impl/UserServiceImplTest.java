package com.codelibrary.javaee.service.jdbc.impl;

import java.sql.SQLException;

import org.junit.Test;

import com.codelibrary.javaee.UnitTestBaseSpring;
import com.codelibrary.javaee.entry.jdbc.User;

public class UserServiceImplTest extends UnitTestBaseSpring {

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
