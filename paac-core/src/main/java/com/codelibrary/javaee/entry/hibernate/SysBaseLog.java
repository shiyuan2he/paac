package com.codelibrary.javaee.entry.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @description <p>系统日志记录类</p>
 * @path paac-core/com.codelibrary.javaee.entry.hibernate.User.java	
 * 2016年7月6日
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Entity
@Table(name="wt_sys_base_log",schema="paac")
public class SysBaseLog implements java.io.Serializable{
	/**
	 * @description <p></p>
	 */
	private static final long serialVersionUID = 1L;
	private String id ; // 系统日志表主键
	private java.util.Date createTime ; //请求时间
	private String createUserId ;// 请求用户id
	private String createUserName ;// 请求人名字	游客，系统用户
	private String requestUrl ;// 请求操作地址
	private String requestRemark ;// 请求操作描述
	private String requestIP ;// 请求机器ip
	private String requestMac ;// 请求机器物理地址
	private String requestTime ;// 请求花费时间
	
	public SysBaseLog() {
		super();
	}
	
	public SysBaseLog(String id, Date createTime, String createUserId, String createUserName, String requestUrl,
			String requestRemark, String requestIP, String requestMac, String requestTime) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.requestUrl = requestUrl;
		this.requestRemark = requestRemark;
		this.requestIP = requestIP;
		this.requestMac = requestMac;
		this.requestTime = requestTime;
	}

	@Id
	@Column(nullable=false,unique=true)
	@GenericGenerator(name="PAAC_ID",strategy="com.codelibrary.javaee.utils.IDGeneratorHelper")
	@GeneratedValue(generator="PAAC_ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(nullable=false,unique=true,length=64)
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	@Column(nullable=false,unique=true)
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	@Column(nullable=false,unique=true)
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	@Column
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	@Column
	public String getRequestRemark() {
		return requestRemark;
	}
	public void setRequestRemark(String requestRemark) {
		this.requestRemark = requestRemark;
	}
	@Column(nullable=false,length=24)
	public String getRequestIP() {
		return requestIP;
	}
	public void setRequestIP(String requestIP) {
		this.requestIP = requestIP;
	}
	@Column(nullable=false,length=64)
	public String getRequestMac() {
		return requestMac;
	}
	public void setRequestMac(String requestMac) {
		this.requestMac = requestMac;
	}
	@Column(nullable=false)
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
}
