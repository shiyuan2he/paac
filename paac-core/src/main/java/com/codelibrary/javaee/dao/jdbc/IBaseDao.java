package com.codelibrary.javaee.dao.jdbc;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author robot
 * @date May 1, 2016 4:40:41 PM
 * @email shiyuan4work@sina.com
 */
public interface IBaseDao<O extends Serializable> {
	/******************************	 增	*****************************/
	void save(O o) throws SQLException ;
	
	void batchSave(List<O> os) ;
	/******************************	 删	*****************************/
	void delete(O o) ;
	
	void batchDelete(List<O> os) ;
	/******************************	 改	*****************************/
	
	void update(O o) ;
	
	void batchUpdate(List<O> os) ;
	/******************************	 查	*****************************/
	
	List<O> find() ;
	
	int Count() ;
	
}
