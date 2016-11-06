package com.codelibrary.javaee.entry.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * @path paac-core/com.codelibrary.javaee.entry.hibernate.MenuRightsRelation.java
 * @description <p>请在这里输入类的描述</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月2日 下午6:05:03
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
@Entity
@Table(name="wt_rights_menu_relation",schema="paac")
public class RightsMenuRelation  implements Serializable{
	/**
	 * @description <p>请再次输入属性描述</p>
	 */
	private static final long serialVersionUID = 1L;
	private String id;//权限关系表主键id
	private Date inputTime;//创建时间
	private String inputUser;//创建者
	private Date updateTime;//更新时间
	private String upUser;//更新者
	private Character isDel;//是否删除 0未删除 1已删除（逻辑）
	
	//private MenuRights menuRights ;//菜单表外键
	//private User user ;//用户表外键
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
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	@Column(nullable=false,length=24)
	public String getInputUser() {
		return inputUser;
	}
	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}
	@Column(nullable=false,length=24)
	public String getUpUser() {
		return upUser;
	}
	public void setUpUser(String upUser) {
		this.upUser = upUser;
	}
	@Column(length=24)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "isDel", nullable = false, precision = 1, scale = 0)
	public Character getIsDel() {
		return isDel;
	}
	public void setIsDel(Character isDel) {
		this.isDel = isDel;
	}
	/*public MenuRights getMenuRights() {
		return menuRights;
	}
	public void setMenuRights(MenuRights menuRights) {
		this.menuRights = menuRights;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
}


