package com.codelibrary.javaee.entry.bean;

import java.util.List;

/**
 * @author heshiyuan @date 2016年10月31日 上午9:48:31
 * @description <p>存放在session中的javabean</p>
 * @copyright 此代码版权归heshiyuan所有，如有粘贴复制请通知本人  邮箱：shiyaun4work@sina.com	
 *
 */
public class UserInfoBean {
	private String userId ;//用户信息表主键
	private String username ;//用户名
	private String userLastLoginIp ;//用户上次登陆ip
	private String userCurrentLoginIp ;//用户本次登陆ip
	private List<RightsMenuTree> rightsTreeList; //菜单树
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserLastLoginIp() {
		return userLastLoginIp;
	}
	public void setUserLastLoginIp(String userLastLoginIp) {
		this.userLastLoginIp = userLastLoginIp;
	}
	public List<RightsMenuTree> getRightsTreeList() {
		return rightsTreeList;
	}
	public void setRightsTreeList(List<RightsMenuTree> rightsTreeList) {
		this.rightsTreeList = rightsTreeList;
	}
	public String getUserCurrentLoginIp() {
		return userCurrentLoginIp;
	}
	public void setUserCurrentLoginIp(String userCurrentLoginIp) {
		this.userCurrentLoginIp = userCurrentLoginIp;
	}
}
