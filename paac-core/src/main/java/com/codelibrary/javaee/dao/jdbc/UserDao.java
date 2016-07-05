package com.codelibrary.javaee.dao.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.codelibrary.javaee.entry.jdbc.User;

/**
 * @path paac-core/com.codelibrary.javaee.dao.jdbc/UserDao.java	
 * @time May 1, 2016 10:25:30 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public interface UserDao {
	
	void saveUser(User user) throws SQLException ;
	
	List<User> findUser(User user) throws SQLException  ;
}
