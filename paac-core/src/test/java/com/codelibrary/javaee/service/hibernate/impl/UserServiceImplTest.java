package com.codelibrary.javaee.service.hibernate.impl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codelibrary.javaee.entry.hibernate.User;
import com.codelibrary.javaee.service.IUserService;
import com.hsy.codebase.utils.javase.bean.BeanHelper;
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
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
		if(!BeanHelper.isNull(userService)){
			boolean flag = userService.login(user) ;
			System.out.println(flag);
		}
	}
	@Test
	public void testRegister(){
		User user = new User() ;
		user.setUsername("张三");
		user.setPassword("admin");
		if(!BeanHelper.isNull(userService)){
			boolean flag = userService.register(user) ;
			System.out.println(flag);
		}
	}
}

