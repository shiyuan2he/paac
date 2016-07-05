package com.codelibrary.javaee.service.jdbc.impl;

import java.sql.SQLException;

import org.junit.Test;

import com.codelibrary.javaee.UnitTestBaseSpring;
import com.codelibrary.javaee.dao.jdbc.UserDao;
import com.codelibrary.javaee.entry.jdbc.User;
import com.codelibrary.javaee.service.UserService;

public class UserServiceImplTest extends UnitTestBaseSpring {

	@Test
	public void testLogin(){
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
		try {
			UserDao userDao = super.getBean("userService");
			userDao.saveUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testAddUser() throws SQLException{
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
		UserService userService = super.getBean("userService");
	}
}
