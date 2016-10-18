package com.codelibrary.javaee.action;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codelibrary.javaee.action.user.UserAction;
/**
 * 
 * @author heshiyuan @date 2016年10月18日 下午6:42:20
 * @description <p>action没有测试的必要</p>
 *
 */
public class TestUserAction {
	private static ApplicationContext context;
	private static UserAction userAction ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath*:spring/spring-*.xml");
		userAction = (UserAction)context.getBean("userAction") ;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Test
	public void test() {
		userAction.do_register() ;
	}

}
