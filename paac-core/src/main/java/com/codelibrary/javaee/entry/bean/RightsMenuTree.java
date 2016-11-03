package com.codelibrary.javaee.entry.bean;

import java.util.List;

/**
 * @path paac-core/com.codelibrary.javaee.entry.bean.MenuRightsTree.java
 * @description <p>菜单权限树</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月3日 下午4:18:53
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
public class RightsMenuTree implements java.io.Serializable{

	/**
	 * @description <p>请再次输入属性描述</p>
	 */
	private static final long serialVersionUID = 1L;
	private String id;// 节点编码
	private String name;// 节点名称
	private String code;// 节点路径1,11,111,1111
	private List<RightsMenuTree> nodes;// 该节点的子集
	private boolean open = false; // 控制所有数据节点都打开
	private boolean checked = false; // 控制某些节点默认选中
	private String menuName;
	private String menuParent;
	private String menuId;
	private String menuType;//菜单类型0菜单1菜单项2功能按钮
	private String menuUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<RightsMenuTree> getNodes() {
		return nodes;
	}
	public void setNodes(List<RightsMenuTree> nodes) {
		this.nodes = nodes;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
}


