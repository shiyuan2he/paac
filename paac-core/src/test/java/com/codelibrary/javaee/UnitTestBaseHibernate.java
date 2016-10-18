package com.codelibrary.javaee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path paac-core/com.codelibrary.javaee.UnitTestBaseHibernate.java	
 * @time 2016年5月28日 下午8:26:55
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class UnitTestBaseHibernate {
	protected SessionFactory sessionFactory ;
	protected Session session ;
	protected Transaction transaction ;
	@Before
	public void before(){
		//创建hibernate配置对象
		//Configuration config = new Configuration().configure() ;
		//创建服务注册对象
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry() ;
		//生成sessionFactory
		//sessionFactory = config.buildSessionFactory(serviceRegistry) ;
		//session = sessionFactory.openSession() ;
		//transaction = session.beginTransaction();
		//SchemaExport export = new SchemaExport(config) ;
		//export.create(true, true);
	}
	@After
	public void after(){
		//transaction.commit();
		//session.close() ;
		//sessionFactory.close();
	}
}

