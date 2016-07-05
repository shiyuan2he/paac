package com.codelibrary.javaee.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @email shiyuan4work@sina.com
 * @author heshiyuan
 * @date May 1, 2016 9:28:57 PM
 */
public class JDBCUtils {

	private static String 	   URL = null;
	private static String     USER = null;
	private static String PASSWORD = null;
	private static String   DRIVER = null;
	
	static{
		Properties prop = new Properties() ;
		try {
			prop.load(JDBCUtils.class.getResourceAsStream("/dbconfig/jdbc.properties"));
			DRIVER 	 = prop.getProperty("jdbc.mariadb.driver") .toString();
			URL      = prop.getProperty("jdbc.mariadb.url") .toString() ;
			USER     = prop.getProperty("jdbc.mariadb.user") .toString() ;
			PASSWORD = prop.getProperty("jdbc.mariadb.password")  .toString();
		} catch (IOException e) {
			System.out.print("读取配置文件出错！！！出错信息："+e.getMessage());
		}
	}
	public static Connection getConnection() {
		  try {
		   Class.forName(DRIVER);
		   Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		   return conn;
		  } catch (Exception e) {
		   System.out.println("获取数据库连接出错！！！出错信息："+e.getMessage());
		   return null;	
		  }
	}
	public static void closeResource(Connection conn,Statement ps,ResultSet rs) {
		  if(conn != null){
			  try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭Connection出错！！！出错信息："+e.getMessage());
			}
		  }
		  if(ps != null){
			  try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("关闭Statement出错！！！出错信息："+e.getMessage());
			}
		  }
		  if(rs != null){
			  try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("关闭ResultSet出错！！！出错信息："+e.getMessage());
			}
		  }
	}
}
