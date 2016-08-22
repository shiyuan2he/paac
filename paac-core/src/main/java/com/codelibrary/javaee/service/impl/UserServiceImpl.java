/**
 * @path paac-core/com.codelibrary.javaee.service.impl/UserServiceImpl.java	
 * @time May 2, 2016 5:20:15 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.service.impl;


import com.codelibrary.javaee.dao.hibernate.BaseDao;
import com.codelibrary.javaee.entry.hibernate.User;
import com.codelibrary.javaee.service.UserService;
@org.springframework.transaction.annotation.Transactional
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {
	@org.springframework.beans.factory.annotation.Autowired
	private BaseDao<User,String> baseDao ;

	public boolean login(User user) {
		return false;
	}

	public boolean register(User user) {
		if(user != null){
		}
		return true;
	}
}

