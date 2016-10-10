/**
 * @path paac-core/com.codelibrary.javaee.service.impl/UserServiceImpl.java	
 * @time May 2, 2016 5:20:15 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.service.impl;


import com.codelibrary.javaee.dao.hibernate.IBaseDao;
import com.codelibrary.javaee.entry.hibernate.User;
import com.codelibrary.javaee.service.IUserService;
import com.hsy.codebase.utils.javase.secure.Base64Helper;
import com.hsy.codebase.utils.javase.string.StringHelper;
@org.springframework.transaction.annotation.Transactional
@org.springframework.stereotype.Service
public class UserServiceImpl implements IUserService {
	@org.springframework.beans.factory.annotation.Autowired
	private IBaseDao<User,String> baseDao ;
	@Override
	public boolean login(User user) {
		return false;
	}
	@Override
	public boolean register(User user) {
		if(user != null && StringHelper.isNotNullOrEmpty(user.getPassword())){
			user.setPassword(Base64Helper.stringToBase64(user.getPassword()));
			String id = (String) baseDao.save(user) ;
			if(StringHelper.isNotNullOrEmpty(id)){
				return true;
			}
		}
		return false ;
	}
}

