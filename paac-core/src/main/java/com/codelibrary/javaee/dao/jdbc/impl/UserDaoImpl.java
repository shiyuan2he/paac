/**
 * @path paac-core/com.codelibrary.javaee.dao.jdbc.impl/UserDaoImpl.java	
 * @time May 1, 2016 10:32:04 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.codelibrary.javaee.dao.jdbc.UserDao;
import com.codelibrary.javaee.entry.jdbc.User;
import com.codelibrary.javaee.utils.JDBCUtils;
@Component
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public void saveUser(User user) throws SQLException {
		Connection conn = JDBCUtils.getConnection() ;
		StringBuilder sql = new StringBuilder() ;
			sql.append("insert into wt_base_user(id,username,password)") ;
			sql.append(" values('"+(int)(Math.random()*10000)+"','"+user.getUsername()+"','"+user.getPassword()+"')") ;
		PreparedStatement psmt =  conn.prepareStatement(sql.toString()) ;
		int count = psmt.executeUpdate() ;
		if(count > 0){
			System.out.println("执行"+count+"条成功");
		}else{
			System.out.println("执行失败");
		}
	}
	@Override
	public List<User> findUser(User user) throws SQLException {
		Connection conn = JDBCUtils.getConnection() ;
		StringBuilder sql = new StringBuilder() ;
		sql.append("select username,password from wt_base_user where username = ? and password = ?") ;
		PreparedStatement psmt = conn.prepareStatement(sql.toString()) ;
		psmt.setString(1, user.getUsername());
		psmt.setString(2, user.getPassword());
		ResultSet rs = psmt.executeQuery() ;
		ResultSetMetaData rsmd = rs.getMetaData() ;
		rs.beforeFirst();
		while(rs.next()){
			System.out.println(rsmd.getColumnCount());
			for(int i=1;i<=rsmd.getColumnCount();i++){
				System.out.println(rs.getString(i));
			}
		}
		return null;
	}
}

