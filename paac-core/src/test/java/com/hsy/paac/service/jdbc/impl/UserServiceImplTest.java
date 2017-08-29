package com.hsy.paac.service.jdbc.impl;

import java.sql.SQLException;

import com.hsy.paac.UnitTestBaseSpring;
import com.hsy.paac.entry.jdbc.User;
import org.junit.Test;

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
