/**
 * @path paac-core/com.codelibrary.javaee.service.impl/UserServiceImpl.java	
 * @time May 2, 2016 5:20:15 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	private IBaseDao<User,String> baseDao ;
	@Override
	public boolean login(String username,String password) {
		String encryptionPassword = Base64Helper.stringToBase64(password);
		String hql = "from User user where user.username=? and user.password=?" ;	
		List<User> userList = baseDao.find(hql, new Object[]{username,encryptionPassword}) ;
		if(BeanHelper.isNotNull(userList)&&userList.size()==1
				&&StringHelper.equals(username, userList.get(0).getUsername())
				&&StringHelper.equals(password, Base64Helper.base64ToString(userList.get(0).getUsername()))){
			return true ;
		}
		return false;
	}
	/**
	 * 
	 * @description <p>注册</p>
	 * @param username 注册用户名
	 * @param password 注册密码
	 * @return
	 * @returnType boolean 注册成功标识
	 * 方法名:register
	 * 类名:UserServiceImpl
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月10日 下午4:11:06
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	@Override
	public boolean register(String username,String password) {
		String encryptionPassword = Base64Helper.stringToBase64(password);
		String hql = "from User user where user.username=? and user.password=?" ;	
		List<User> userList = baseDao.find(hql, new Object[]{username,encryptionPassword}) ;
		if(BeanHelper.isNotNull(userList.get(0))&&StringHelper.equals(username, userList.get(0).getUsername())){
			return false ;
		}
		if(BeanHelper.isNotNull(userList.get(0))&&StringHelper.equals(password, Base64Helper.base64ToString(userList.get(0).getUsername()))){
			return false ;
		}
		User user = new User() ;
		if(StringHelper.isNotNullOrEmpty(password) && StringHelper.isNotNullOrEmpty(username)){
			user.setUsername(username);
			user.setPassword(Base64Helper.stringToBase64(password));
			user.setEncryptionType(Constant.ENCRYPTIONTYPE_BASE64);
			user.setCreateTime(new Date());
			user.setCreater(username);
			user.setIs_del("0"); //未物理删除
			baseDao.save(user) ;//id PAAC147755041671328146.609555849267
			if(StringHelper.isNotNullOrEmpty(user.getId())){
				return true;
			}
		}
		return false ;
	}
}

