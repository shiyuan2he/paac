package com.hsy.paac.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * @description <p>hibernate基础类接口</p>
 * @path paac-core/com.codelibrary.javaee.dao.hibernate.BaseDao.java	
 * @time 2016年5月24日 上午12:05:45
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public interface IBaseDao<O,S extends java.io.Serializable> {
	
	/*	增	***************************************************************************************/
	public Serializable save(S s);
	/*	删	***************************************************************************************/
	public void delete(S s) ;
	/*	改	***************************************************************************************/
	public void update(S s) ;
	/*	查	***************************************************************************************/
	/**
	 * @description 
	 *		<p>根据主键查询所见所属的类</p>
	 * @time 2016年7月3日 下午5:35:59
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType O
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public O get(Class<O> o,java.io.Serializable s) ;
	/**
	 * 
	 * @description 
	 *		<p>根据书写的hql查询list结果集</p>
	 * @time 2016年7月3日 下午8:25:59
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType List<O>
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public List<O> find(String hql) ;
	/**
	 * 
	 * @description 
	 *		<p>根据Object［］和hql查询结果集</p>
	 * @time 2016年7月3日 下午8:27:37
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType List<O>
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public List<O> find(String hql,java.lang.Object[] param) ;
	/**
	 * 
	 * @description
	 *		<p>根据map列参数和hql查询结果集</p>
	 * @time 2016年7月3日 下午8:27:43
	 * @github
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType List<O>
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public List<O> find(String hql,java.util.Map<String,Object> param) ;
	/**
	 * 
	 * @description 
	 *		<p>根据list参数和hql查询结果集</p>
	 * @time 2016年7月3日 下午8:27:49
	 * @github
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType List<O>
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public List<O> find(String hql,java.util.List<Object> param) ;
}


