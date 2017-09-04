package com.hsy.paac.urms.base.hibernate.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hsy.paac.urms.base.hibernate.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description <p>hibernate公共dao曾方法</p>
 * @path paac-core/com.codelibrary.javaee.dao.hibernate.impl.BaseDaoImpl.java	
 * @time 2016年5月24日 上午12:06:57
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Repository("baseDao")
public class BaseDaoImpl<O, S extends java.io.Serializable> implements IBaseDao<O, S> {
	private SessionFactory sessionFactory;
	//private org.springframework.orm.hibernate4.HibernateTemplate hibernateTemplate ;
	//private org.springframework.orm.hibernate4.support.HibernateDaoSupport hibernateDaoSupport ;
	//private org.springframework.orm.hibernate4.SessionFactoryUtils sessionFactoryUtils ;
	
	private BaseDaoImpl(){}
	
	/**
	 * 
	 * @description 
	 *		<p>session有没有必要做成单例的</p>
	 * @time 2016年5月29日 下午8:45:50
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType org.hibernate.Session 
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public Session getSession(){
		return sessionFactory.getCurrentSession() ;
	}
	/*	增	***************************************************************************************/
	public java.io.Serializable save(S s){
		return this.getSession().save(s);
	}
	
	/*	删	***************************************************************************************/
	public void delete(S s){
		this.getSession().delete(s);
	}
	
	/*	改	***************************************************************************************/
	public void update(S s){
		this.getSession().update(s);
	}
	public void saveOrUpdate(S s){
		this.getSession().saveOrUpdate(s);
	}
	public void merge(S s){
		this.getSession().merge(s);
	}
	/*	查	***************************************************************************************/
	public O get(Class<O> c, Serializable s) {
		return (O) this.getSession().get(c, s);
	}
	
	@SuppressWarnings("unchecked")
	public List<O> find(String hql){
		return this.getSession().createQuery(hql).list() ;
	}
	@SuppressWarnings("unchecked")
	public List<O> find(String hql, Object[] param) {
		org.hibernate.Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<O> find(String hql, List<Object> param) {
		org.hibernate.Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<O> find(String hql, Map<String,Object> param) {
		org.hibernate.Query query = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			Set<String> keySet = param.keySet();
			for (Iterator<String> ite = keySet.iterator(); ite.hasNext();) {
				String key = (String) ite.next();
				query.setParameter(key, param.get(key));
			}
		}
		return query.list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * 
	 * @description 
	 *		<p>从spring容器（spring－dao）注入sessionFactory</p>
	 * @time 2016年7月3日 下午5:32:47
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType void
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/*public org.springframework.orm.hibernate4.HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}*/
	/**
	 * @description 
	 *		<p>从spring容器（spring－dao）注入hibernateTemplate</p>
	 * @time 2016年7月3日 下午5:31:51
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType void
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	/*public void setHibernateTemplate(org.springframework.orm.hibernate4.HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
	/*public org.springframework.orm.hibernate4.support.HibernateDaoSupport getHibernateDaoSupport() {
		return hibernateDaoSupport;
	}*/
	/**
	 * @description 
	 *		<p>从spring容器（spring－dao）注入hibernateDaoSupport</p>
	 * @time 2016年7月3日 下午5:30:47
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType void
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	/*public void setHibernateDaoSupport(org.springframework.orm.hibernate4.support.HibernateDaoSupport hibernateDaoSupport) {
		this.hibernateDaoSupport = hibernateDaoSupport;
	}

	public org.springframework.orm.hibernate4.SessionFactoryUtils getSessionFactoryUtils() {
		return sessionFactoryUtils;
	}

	public void setSessionFactoryUtils(
			org.springframework.orm.hibernate4.SessionFactoryUtils sessionFactoryUtils) {
		this.sessionFactoryUtils = sessionFactoryUtils;
	}*/
}

