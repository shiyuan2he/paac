/**
 * @path paac-core/com.codelibrary.javaee.service.impl/UserServiceImpl.java	
 * @time May 2, 2016 5:20:15 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codelibrary.javaee.dao.hibernate.IBaseDao;
import com.codelibrary.javaee.entry.hibernate.User;
import com.codelibrary.javaee.service.IUserService;
import com.codelibrary.javaee.utils.Constant;
import com.hsy.codebase.utils.javase.bean.BeanHelper;
import com.hsy.codebase.utils.javase.secure.Base64Helper;
import com.hsy.codebase.utils.javase.string.StringHelper;
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	@Qualifier("baseDao")
	private IBaseDao<User,String> baseDao ;
	public boolean login(User user) {
		String hql = "from User user where user.username=? and user.password=?" ;	
		List<User> userList = baseDao.find(hql, new Object[]{user.getUsername(),user.getPassword()}) ;
		if(BeanHelper.isNull(userList.get(0))){
			return true ;
		}
		return false;
	}
	public boolean register(User user) {
		if(user != null && StringHelper.isNotNullOrEmpty(user.getPassword())){
			user.setPassword(Base64Helper.stringToBase64(user.getPassword()));
			user.setEncryptionType(Constant.ENCRYPTIONTYPE_BASE64);
			user.setIs_del("0"); //未物理删除
			baseDao.save(user) ;
			//String id = (String) baseDao.save(user) ;
			if(StringHelper.isNotNullOrEmpty(user.getId())){
				return true;
			}
		}
		return false ;
	}
}

