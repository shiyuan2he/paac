package com.hsy.paac.service.base.impl;

import java.io.Serializable;

import com.hsy.paac.dao.hibernate.IBaseDao;
import com.hsy.paac.service.base.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
