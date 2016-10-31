package com.codelibrary.javaee.entry.bean;
/**
 * @author heshiyuan @date 2016年10月31日 上午9:48:31
 * @description <p>存放在session中的javabean</p>
 * @copyright 此代码版权归heshiyuan所有，如有粘贴复制请通知本人  邮箱：shiyaun4work@sina.com	
 *
 */
public class UserInfoBean {
	private String userId ;//用户信息表主键
	private String username ;//用户名
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
}
