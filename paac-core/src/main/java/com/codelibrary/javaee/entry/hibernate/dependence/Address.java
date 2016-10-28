package com.codelibrary.javaee.entry.hibernate.dependence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @description <p>用户基本信息表的嵌入类</p>
 * @path paac-core/com.codelibrary.javaee.entry.hibernate.Address.java	
 * @time 2016年5月25日 上午12:08:45
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Embeddable // 表示是一个嵌入类，这个类对象在别的实体充当一个属性
public class Address {
	private String postCode ; //邮编
	private String address ; // 地址
	private String phone ; //联系方式
	
	public Address() {}
	public Address(String postCode, String address, String phone) {
		this.postCode = postCode;
		this.address = address;
		this.phone = phone;
	}
	@Column(name="postCode",length=6)
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	@Column(name="address",length=50)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="phone",unique=true,length=11)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
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
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [postCode=" + postCode + ", address=" + address + ", phone=" + phone + "]";
	}
}

