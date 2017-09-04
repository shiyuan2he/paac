package com.hsy.paac.urms.base.action.menu;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

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
public class MenuAction extends ActionSupport{

	/**
	 * @description <p></p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @description 
	 *		<p></p>
	 * @time 2016年10月15日 上午11:31:56
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType String
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public String to_main(){
		return "to_main" ;
	}
	
}

