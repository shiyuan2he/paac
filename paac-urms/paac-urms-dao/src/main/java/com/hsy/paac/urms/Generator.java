package com.hsy.paac.urms;
import com.hsy.paac.base.util.MybatisGeneratorUtil;
import com.hsy.paac.base.util.PropertiesFileUtil;

import java.util.HashMap;
import java.util.Map;
/**
 * @description <p></p>
 * @author heshiyuan
 * @date 04/09/2017 11:34 AM 
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Generator {

	// 根据命名规范，只修改此常量值即可
	private static String MODULE = "paac-urms";
	private static String DATABASE = "paac";
	private static String TABLE_PREFIX = "t_urms";
	private static String PACKAGE_NAME = "com.hsy.paac.urms";
	private static String JDBC_DRIVER = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.driver");
	private static String JDBC_URL = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.url");
	private static String JDBC_USERNAME = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.username");
	private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.password");
	// 需要insert后返回主键的表配置，key:表名,value:主键名
	private static Map<String, String> LAST_INSERT_ID_TABLES = new HashMap<>();
	static {
		LAST_INSERT_ID_TABLES.put("t_urms_permission", "permission_id");
	}

	/**
	 * 自动代码生成
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MybatisGeneratorUtil.generator(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE, DATABASE, TABLE_PREFIX, PACKAGE_NAME, LAST_INSERT_ID_TABLES);
	}

}
