package com.hsy.codebase.utils.javase.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path paac-base/com.hsy.codebase.utils.javase.string.StringHelp.java	
 * @time 2016年6月1日 下午9:45:37
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class StringHelper extends StringUtils{
	
	/**
	 * 
	 * @description 
	 *		<p>判断字符串是否是空，null或""</p>
	 * @time 2016年5月29日 下午8:45:50
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean 
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean isNullOrEmpty(String str){
		return str==null || StringUtils.isEmpty(str) ;
	}
	/**
	 * 
	 * 
	 * @description 
	 *		<p></p>
	 * @time 2016年7月3日 下午5:14:20
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean isNotNullOrEmpty(String str){
		return !isNullOrEmpty(str) ;
	}
	
}

