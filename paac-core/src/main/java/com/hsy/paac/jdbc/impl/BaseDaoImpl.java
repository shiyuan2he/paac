package com.hsy.paac.jdbc.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.hsy.paac.jdbc.IBaseDao;
import com.hsy.paac.utils.JDBCUtils;

/**
 * 
 * @author heshiyuan
 * @date Apr 25, 2016 11:50:17 PM
 * @email shiyuan4work@sina.com
 * 
 */
public class BaseDaoImpl<O extends Serializable> implements IBaseDao<O> {
	

	public void save(O o) throws SQLException {
		Connection conn = JDBCUtils.getConnection() ;
		String sql = "" ;
		@SuppressWarnings("unused")
		PreparedStatement psmt =  conn.prepareStatement(sql) ;
	}

	public void batchSave(List<O> os) {
		
	}

	public void delete(O o) {
		
	}

	public void batchDelete(List<O> os) {
		
	}

	public void update(O o) {
		
	}

	public void batchUpdate(List<O> os) {
		
	}

	public List<O> find() {
		return null;
	}

	public int Count() {
		return 0;
	}
	
	
	
	
}
