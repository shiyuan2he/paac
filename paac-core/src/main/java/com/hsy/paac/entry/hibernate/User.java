package com.hsy.paac.entry.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.hsy.paac.annotation.NameColumn;
import com.hsy.paac.annotation.VerifyColumn;
import com.hsy.paac.entry.hibernate.dependence.Address;
import org.hibernate.annotations.GenericGenerator;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path paac-core/com.codelibrary.javaee.entry.hibernate.User.java	
 * @time 2016年5月24日 上午12:04:24
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
/**
 * 类级别的注解 // 优先采用JPA注解
 */
//@Entity(name="wt_base_user") 
@Entity
@Table(name="wt_base_user",schema="paac")
public class User implements Serializable{
	/**
	 * 生成版本序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 1.属性级别注解可以写在属性上，也可以写在get方法上
	 * 2.@Id
	 * 		一个表可以存在多个主键，即可以存在多个@Id注解，但String类型的逐渐要设置指定长度
	 * 3.@GeneratedValue
	 * 		GenerationType.AUTO ： 根据底层数据库自动选择（默认） 主键类型是Integer的在可以使用此种生成方式
	 * 		GenerationType.IDENTITY ： 根据数据库的Identify字段生成
	 * 		GenerationType.SEQUENCE	：使用sequence来决定主键的取值，适用于oracle，db2
	 * 		GenerationType.TABLE	：使用制定表来决定主键取值
	 * 4.@Embedded
	 * 		表示此属性是一个嵌入类
	 * 5.@Transient
	 * 		可选，表示该属性并非一个到数据库表的字段的映射，ORM框架将忽略该属性，如果一个属性并非数据库表的字段，就务必将其标为@Transient，
	 * 		否则，ORM框架将默认是注解是@Basic
	 * 
	 */
	private String id ; // 用户表主键
	private String username ; //登陆名
	private String realname; //真实姓名
	private String nickname; //用户昵称
	private String password ; //用户密码
	private String encryptionType ; //加密类型	base64，md5
	private String certNo ; //身份证号码
	private Date birth ;	//出生日期
	private Address address ; // 住址
	private Date createTime ;//创建账号日期
	private String creater ;//创建账号日期
	private Date upTime ;// 修改帐号日期
	private String upUser ; //修改帐号人  本人或者管理员
	private String isDel ;//是否物理删除 1 是 0 否
	private String email ;//用户邮箱
	private Integer gender ;//用户性别 1 男 2女
	private String genderValue ;//用户性别-中文
	
	public User() {}

	public User(String username, String password, String realname, String certNo, Date birth, Address address) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.certNo = certNo;
		this.birth = birth;
		this.address = address;
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
	@Column(nullable=false,unique=true,length=32)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(nullable=false,unique=true,length=64)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@NameColumn(value = "真实姓名")
	@VerifyColumn(value = "(^[\\u4e00-\\u9fa5]{2,10}$)")
	@Column(length=10)
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	@Column(unique=true,length=64)
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Temporal(TemporalType.TIMESTAMP)//格式化时间格式
	@Column(nullable=false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(nullable=false,length=24)
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	@Column
	public Date getUpTime() {
		return upTime;
	}
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	@Column(length=24)
	public String getUpUser() {
		return upUser;
	}

	public void setUpUser(String upUser) {
		this.upUser = upUser;
	}
	@Column(name = "isDel", nullable = false, length=1)
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	@Column(name="certNo",unique=true,length=18)
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	@Column(name="encryptionType",nullable=false,length=10)
	public String getEncryptionType() {
		return encryptionType;
	}
	public void setEncryptionType(String encryptionType) {
		this.encryptionType = encryptionType;
	}
	@NameColumn(value = "邮箱")
	@Column(name = "email", length = 50)
	@VerifyColumn(value = "(^[0-9a-zA-Z_\\.]+@\\w+\\.\\w+\\.?\\w+$)")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "gender", length = 1)
	@VerifyColumn(value = "(^[12]{1,1}$)")
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Transient
	public String getGenderValue() {
		if (gender == 1)
			genderValue = "男";
		else if (gender == 2)
			genderValue = "女";
		return genderValue;
	}
	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}

