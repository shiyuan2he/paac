/**
 * @path paac-core/com.codelibrary.javaee.service/UserService.java	
 * @time May 2, 2016 5:19:02 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.service;

public interface UserService {
	boolean login(com.codelibrary.javaee.entry.hibernate.User user);
	boolean register(com.codelibrary.javaee.entry.hibernate.User user);
}

