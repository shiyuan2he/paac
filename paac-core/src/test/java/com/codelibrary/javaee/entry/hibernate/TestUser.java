package com.codelibrary.javaee.entry.hibernate;

import java.util.Date;

import org.junit.Test;

import com.codelibrary.javaee.UnitTestBaseHibernate;
import com.codelibrary.javaee.entry.hibernate.dependence.Address;
/**
 * @description <p>请在此处输入类的描述</p>
 * @path paac-core/com.codelibrary.javaee.entry.hibernate.TestUser.java	
 * @time 2016年5月24日 下午11:21:05
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class TestUser extends UnitTestBaseHibernate{
	/**
	 * @returnType void
	 * @description 
	 *		<p>测试生成数据库表结构</p>
	 */
	@Test
	public void testHibernateToTable(){}
	@Test
	public void testUserAdd(){
		Address address = new Address("100000","北京市丰台区宋家庄","12345678900") ;
		User user = new User("admin","123","张三","1111111111111111111",new Date(),address) ;
		session.save(user) ;
	}
}

