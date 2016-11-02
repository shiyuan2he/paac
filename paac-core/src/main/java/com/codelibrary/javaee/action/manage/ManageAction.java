package com.codelibrary.javaee.action.manage;

import org.springframework.stereotype.Controller;

import com.codelibrary.javaee.action.base.BaseAction;

/**
 * @description <p>获取菜单action</p>
 * @path paac-core/com.codelibrary.javaee.action.menu
 * @time 2016年10月15日 上午10:33:01
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Controller
public class ManageAction extends BaseAction{

	/**
	 * @description <p></p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @description 
	 *		<p>跳转到主页面</p>
	 * @time 2016年10月15日 上午11:31:56
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType String
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public String toMainView(){
		return "toMainView" ;
	}
	/**
	 * 
	 * @description <p>请在这里输入方法的作用</p>
	 * @return
	 * @returnType String
	 * 方法名:to_main
	 * 类名:ManageAction
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月2日 下午4:40:42
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public String toWelcome(){
		return "toWelcome" ;
	}
	
}

