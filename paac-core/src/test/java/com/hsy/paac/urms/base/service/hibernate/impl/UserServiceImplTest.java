package com.hsy.paac.urms.base.service.hibernate.impl;
import com.hsy.paac.urms.base.service.user.IUserService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsy.paac.urms.base.entry.hibernate.User;
import com.hsy.paac.base.utils.javase.bean.BeanHelper;
/**
 * @description <p>请在此处输入类的描述</p>
 * @path paac-core/com.codelibrary.javaee.service.hibernate.impl.UserServiceImplTest.java	
 * @time 2016年6月17日 下午1:29:00
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class UserServiceImplTest{
	private static ApplicationContext context;
	private static IUserService userService ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath*:spring/spring-*.xml");
		userService = (IUserService)context.getBean("userService") ;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("UserServiceImplTest	tearDownAfterClass");
	}

	@Test
	public void testLogin(){
		if(!BeanHelper.isNull(userService)){
			User flag = userService.login("张三","admin") ;
			System.out.println(flag.toString());
		}
	}
	@Test
	public void testRegister(){
		if(!BeanHelper.isNull(userService)){
			boolean flag = userService.register("张三","admin") ;
			System.out.println(flag);
		}
	}
}

