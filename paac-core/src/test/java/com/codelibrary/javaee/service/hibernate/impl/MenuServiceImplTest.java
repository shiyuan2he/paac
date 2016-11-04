package com.codelibrary.javaee.service.hibernate.impl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codelibrary.javaee.service.menu.IMenuService;

/**
 * @path paac-core/com.codelibrary.javaee.service.hibernate.impl.MenuServiceImplTest.java
 * @description <p>请在这里输入类的描述</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月3日 下午1:57:29
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
public class MenuServiceImplTest {
	
	private static ApplicationContext context;
	private static IMenuService menuService ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath*:spring/spring-*.xml");
		menuService = (IMenuService)context.getBean("menuService") ;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreateMenuRights() {
		/**
		 * @param menuName
		 * @param menuParent
		 * @param menuUrl
		 * @param menuLevel
		 * @param menuOrder
		 */
		menuService.createMenuRights("工作台", "0", "./mainFrame/menu/aa.action", 1,1);
		menuService.createMenuRights("内部维护", "0", "./mainFrame/menu/bb.action", 1,2);
		menuService.createMenuRights("财务管理", "0", "./mainFrame/menu/bb.action", 1,3);
	}

}


