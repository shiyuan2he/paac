/**
 * @path paac-core/com.codelibrary.javaee.service/UserService.java	
 * @time May 2, 2016 5:19:02 PM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.service;

public interface IUserService {
	/**
	 * 
	 * @description <p>登陆</p>
	 * @param user
	 * @return
	 * @returnType boolean
	 * 方法名:login
	 * 类名:UserService
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月10日 下午4:11:06
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	boolean login(String username,String password);
	/**
	 * 
	 * @description <p>注册</p>
	 * @param user
	 * @return
	 * @returnType boolean
	 * 方法名:register
	 * 类名:UserService
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月10日 下午4:11:10
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	boolean register(String username,String password);
}

