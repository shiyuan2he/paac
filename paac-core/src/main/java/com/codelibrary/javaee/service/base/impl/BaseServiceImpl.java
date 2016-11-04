package com.codelibrary.javaee.service.base.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codelibrary.javaee.dao.hibernate.IBaseDao;
import com.codelibrary.javaee.service.base.IBaseService;

@Transactional
@Service("baseService")
public class BaseServiceImpl implements IBaseService {
	@Autowired
	private IBaseDao<Object,Serializable> baseDao ;

	/* (non-Javadoc)
	 * @see com.codelibrary.javaee.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(Serializable s) {
		return baseDao.save(s);
	}
}
