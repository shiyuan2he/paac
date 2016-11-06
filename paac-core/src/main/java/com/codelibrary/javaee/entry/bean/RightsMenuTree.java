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
	private String menuCode;// 节点路径1,11,111,1111
	private String menuParent;//上级菜单ID
	private List<RightsMenuTree> nodes;// 该节点的子集
	private String menuName;//菜单名称
	private String menuType;//菜单类型0菜单1菜单项2功能按钮
	private String menuUrl;//菜单链接地址
	private String menuLevel;//菜单等级
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public List<RightsMenuTree> getNodes() {
		return nodes;
	}
	public void setNodes(List<RightsMenuTree> nodes) {
		this.nodes = nodes;
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
	public String getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
}


