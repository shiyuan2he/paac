package com.codelibrary.javaee.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @description <p>c3p0数据源配置</p>
 * @path paac-core/com.codelibrary.javaee.utils.C3P0Utils.java	
 * @time 2016年5月23日 下午11:43:41
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class C3P0Utils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource() ;
	
	public static Connection getConnetction(){
		try {
			return ds.getConnection() ;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
}

