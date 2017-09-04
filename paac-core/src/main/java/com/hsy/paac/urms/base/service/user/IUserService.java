package com.hsy.paac.urms.base.service.user;

import com.hsy.paac.urms.base.entry.hibernate.User;

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
	User login(String username, String password);
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

