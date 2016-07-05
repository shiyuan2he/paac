package com.codelibrary.javaee.utils;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

/**
 * @description <p>Hibernate主键生成策略</p>
 * @path paac-core/com.codelibrary.javaee.utils.IDGeneratorHelper.java	
 * @time 2016年6月17日 上午10:46:53
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class IDGeneratorHelper implements org.hibernate.id.IdentifierGenerator{

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		return null;
	}
}

