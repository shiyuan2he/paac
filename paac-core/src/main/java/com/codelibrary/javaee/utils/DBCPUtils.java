package com.codelibrary.javaee.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * @date 2016年5月23日 下午11:18:55
 * @author shiyuan2he
 * @copyright @c版权归本人所有，如有复制，剪切请通知本人，邮箱：shiyuan4work@sina.com
 * @description dbcp连接池实现
 */
public class DBCPUtils {

	/** 数据源，static */
	private static DataSource DS;
	private static String configFile = "/dbconfig/dbcp.properties" ;

	/**
	 * 
	 * @return
	 * @returnType Connection
	 * @description 
	 *		<p>从数据源获得一个连接</p>
	 */
	public Connection getConn() {
		Connection con = null;
		if (DS != null) {
			try {
				con = DS.getConnection();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}

			try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		return con;
	}

	/**
	 * <p>第一种创建数据源的方法</p>
	 * 
	 * 请说明此构造器的作用
	 */
	public DBCPUtils() {
		initDBCP() ;
	}
	private static void initDBCP(){
		Properties prop = new Properties() ;
		try {
			prop.load(Object.class.getResourceAsStream(configFile)) ;
			DS = BasicDataSourceFactory.createDataSource(prop) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * <p>第二种创建数据源的方法</p>
	 * 
	 * 请说明此构造器的作用
	 */
	public DBCPUtils(String connectURI) {
		initDS(connectURI);
	}

	/** 构造函数，初始化了 DS ，指定 所有参数 */
	public DBCPUtils(String connectURI, String username, String pswd, String driverClass, int initialSize,
			int maxActive, int maxIdle, int maxWait, int minIdle) {
		initDS(connectURI, username, pswd, driverClass, initialSize, maxActive, maxIdle, maxWait, minIdle);
	}

	/**
	 * 创建数据源，除了数据库外，都使用硬编码默认参数；
	 * 
	 * @param connectURI
	 *            数据库
	 * @return
	 */
	public static void initDS(String connectURI) {
		initDS(connectURI, "root", "password", "com.mysql.jdbc.Driver", 5, 100, 30, 10000, 1);
	}

	/**
	 * 指定所有参数连接数据源
	 * 
	 * @param connectURI
	 *            数据库
	 * @param username
	 *            用户名
	 * @param pswd
	 *            密码
	 * @param driverClass
	 *            数据库连接驱动名
	 * @param initialSize
	 *            初始连接池连接个数
	 * @param maxtotal
	 *            最大活动连接数
	 * @param maxIdle
	 *            最大连接数
	 * @param maxWaitMillis
	 *            获得连接的最大等待毫秒数
	 * @param minIdle
	 *            最小连接数
	 * @return
	 */
	public static void initDS(String connectURI, String username, String pswd, String driverClass, int initialSize,
			int maxtotal, int maxIdle, int maxWaitMillis, int minIdle) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUsername(username);
		ds.setPassword(pswd);
		ds.setUrl(connectURI);
		ds.setInitialSize(initialSize); // 初始的连接数；
		ds.setMaxTotal(maxtotal);
		ds.setMaxIdle(maxIdle);
		ds.setMaxWaitMillis(maxWaitMillis);
		ds.setMinIdle(minIdle);
		DS = ds;
	}

	/** 获得数据源连接状态 */
	public static Map<String, Integer> getDataSourceStats() throws SQLException {
		BasicDataSource bds = (BasicDataSource) DS;
		Map<String, Integer> map = new HashMap<String, Integer>(2);
		map.put("active_number", bds.getNumActive());
		map.put("idle_number", bds.getNumIdle());
		return map;
	}

	/** 关闭数据源 */
	protected static void shutdownDataSource() throws SQLException {
		BasicDataSource bds = (BasicDataSource) DS;
		bds.close();
	}

	public static void main(String[] args) {
		DBCPUtils db = new DBCPUtils("jdbc:mysql://localhost:3306/testit");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from test limit 1 ");
			System.out.println("Results:");
			int numcols = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= numcols; i++) {
					System.out.print("\t" + rs.getString(i) + "\t");
				}
				System.out.println("");
			}
			System.out.println(getDataSourceStats());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
				if (db != null)
					shutdownDataSource();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
