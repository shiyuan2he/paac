/**
 * @path paac-core/com.codelibrary.javaee.entry.jdbc/User.java	
 * @time May 1, 2016 10:28:29 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.hsy.paac.urms.base.entry.jdbc;

@SuppressWarnings("serial")
public class User implements java.io.Serializable{
	private Integer id ;
	private String username ;
	private String password ;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}

