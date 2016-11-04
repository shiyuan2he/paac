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
@Table(name="wt_system_log",schema="paac")
public class SystemLog implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String id ; // 系统日志表主键
	private Date createTime ; //请求时间
	private String createUserId ;// 请求用户id
	private String createUserName ;// 请求人名字	游客，系统用户
	private String requestUrl ;// 请求操作地址
	private String requestMethod ;//请求方法
	private String requestRemark ;// 请求操作描述
	private String requestIP ;// 请求机器ip
	private String requestMac ;// 请求机器物理地址
	private String requestTime ;// 请求花费时间
	private String moduleId;//操作对象id
	private String objectId;//成功失败的状态，操作成功或者失败
	private Boolean isDel; //逻辑删除	0未删除 1 已删除
	private String delUser; //逻辑删除者
	private Date delTime; //删除时间
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
	@Column(nullable=false,length=20)
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	@Column(nullable=false)
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	@Column(nullable=false)
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	@Column(nullable=false)
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	@Column(nullable=false)
	public String getRequestRemark() {
		return requestRemark;
	}
	public void setRequestRemark(String requestRemark) {
		this.requestRemark = requestRemark;
	}
	@Column(length=24)
	public String getRequestIP() {
		return requestIP;
	}
	public void setRequestIP(String requestIP) {
		this.requestIP = requestIP;
	}
	@Column(length=20)
	public String getRequestMac() {
		return requestMac;
	}
	public void setRequestMac(String requestMac) {
		this.requestMac = requestMac;
	}
	@Column(nullable=false,length=20)
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	@Column(nullable=false)
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	@Column(nullable=false)
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	@Column(nullable=false)
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	@Column(name = "isDel", nullable = false, precision = 1, scale = 0)
	public boolean getIsDel() {
		return isDel;
	}
	public void setIsDel(boolean isDel) {
		this.isDel = isDel;
	}
	@Column
	public String getDelUser() {
		return delUser;
	}

	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
	@Column
	public Date getDelTime() {
		return delTime;
	}
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}
}
