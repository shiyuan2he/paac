package com.codelibrary.javaee.entry.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="wt_menu_rights",schema="paac")
public class MenuRights {
	private String id ; //主键
	private String menuCode ; //菜单编码
	private String menuName ; //菜单名称
	private String menuParent ; //父菜单
	private Integer menuOrder ; //菜单排序
	private String menuUrl ; //菜单地址
	private char menuType ; //菜单类型
	private Integer menuLevel ; //菜单级别
	private Integer is_del ; // 是否删除 0.未删除 1.已删除
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
	@Column(nullable=false,unique=true,length=30)
	public String getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}
	@Column(nullable=false,unique=true,length=64)
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
	@Column(nullable=false,unique=true,length=1)
	public char getMenuType() {
		return menuType;
	}
	public void setMenuType(char menuType) {
		this.menuType = menuType;
	}
	@Column(nullable=false,unique=true,length=1)
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	@Column(nullable=false,unique=true,length=1)
	public Integer getIs_del() {
		return is_del;
	}
	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}
}
