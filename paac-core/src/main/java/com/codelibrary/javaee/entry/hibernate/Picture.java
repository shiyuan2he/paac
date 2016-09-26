package com.codelibrary.javaee.entry.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="wt_picture",schema="paac")
public class Picture {
	private String id ;// 图片唯一主键
	private String picUrl ; //图片所对应的图片服务器地址
	private String picAddress ; //图片拍摄地址
	private String picDescription ; //图片描述
	private String picCreater ; //图片创建者
	private String picCreateTime ; //图片创建时间
	@Id
	@Column(nullable=false,unique=true)
	@GenericGenerator(name="paacID",strategy="com.codelibrary.javaee.utils.IDGeneratorHelper")
	@GeneratedValue(generator="paacID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(nullable=false,unique=true,length=64)
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	@Column(nullable=false,unique=true,length=20)
	public String getPicAddress() {
		return picAddress;
	}
	public void setPicAddress(String picAddress) {
		this.picAddress = picAddress;
	}
	@Column(nullable=false,unique=true,length=300)
	public String getPicDescription() {
		return picDescription;
	}
	public void setPicDescription(String picDescription) {
		this.picDescription = picDescription;
	}
	@Column(nullable=false,unique=true,length=30)
	public String getPicCreater() {
		return picCreater;
	}
	public void setPicCreater(String picCreater) {
		this.picCreater = picCreater;
	}
	@Column(nullable=false,unique=true,length=30)
	public String getPicCreateTime() {
		return picCreateTime;
	}
	public void setPicCreateTime(String picCreateTime) {
		this.picCreateTime = picCreateTime;
	}
}
