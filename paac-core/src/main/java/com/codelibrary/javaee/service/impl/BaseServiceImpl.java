package com.codelibrary.javaee.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codelibrary.javaee.dao.hibernate.IBaseDao;
import com.codelibrary.javaee.service.IBaseService;

@Transactional
@Service("baseService")
public class BaseServiceImpl implements IBaseService {
	@Autowired
	private IBaseDao<Object,Serializable> baseDao ;
}