package com.hsy.paac.urms.base.entry.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="wt_rights_menu",schema="paac")
public class RightsMenu implements Serializable{
	/**
	 * @description <p>请再次输入属性描述</p>
	 */
	private static final long serialVersionUID = 1L;
	private String id ; //主键
	private String menuCode ; //菜单编码
	private String menuName ; //菜单名称
	private String menuParent ; //父菜单
	private Integer menuOrder ; //菜单排序
	private String menuUrl ; //菜单地址
	private Character menuType ; //菜单类型0菜单1菜单项2功能按钮
	private Integer menuLevel ; //菜单级别
	private String isDel ; // 是否删除
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
	@Column(nullable=false,unique=true,length=30)
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	@Column(nullable=false,unique=true,length=20)
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Column(nullable=false,length=30)
	public String getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}
	@Column(nullable=false,length=64)
	public Integer getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	@Column(nullable=false,unique=true,length=64)
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	@Column(nullable=false,length=1)
	public Character getMenuType() {
		return menuType;
	}
	public void setMenuType(Character menuType) {
		this.menuType = menuType;
	}
	@Column(nullable=false,length=1)
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	@Column(name = "isDel", nullable = false, length=1)
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
}
