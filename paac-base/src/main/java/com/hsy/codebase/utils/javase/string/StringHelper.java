package com.hsy.codebase.utils.javase.string;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @description <p>字符串帮助类，基于java8-92版本和commons-lang3 jar包</p>
 * @path paac-base/com.hsy.codebase.utils.javase.string.StringHelp.java	
 * @time 2016年6月1日 下午9:45:37
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class StringHelper{
	/**
	 * 
	 * @description 
	 *		<p>判断连个字符串是否相等</p>
	 * @time 2016年7月27日 下午8:20:08
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean equals(String str1,String str2){
		return StringUtils.equals(str1, str2) ;
	}
	/**
	 * 
	 * @description 
	 *		<p>判断字符串是否是空，null或""</p>
	 *		<pre>
     * 			StringUtils.isNotEmpty(null)      = false
     * 			StringUtils.isNotEmpty("")        = false
     * 			StringUtils.isNotEmpty(" ")       = true
     * 			StringUtils.isNotEmpty("bob")     = true
     * 			StringUtils.isNotEmpty("  bob  ") = true
     * 		</pre>
	 * @time 2016年5月29日 下午8:45:50
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean 
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean isNullOrEmpty(String str){
		return "".equals(str)||StringUtils.isEmpty(str) ;
	}
	/**
	 * 
	 * 
	 * @description 
	 *		<p>判断字符串非空</p>
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
	/**
	 * 
	 * @description 
	 *		<p></p>
	 * @time 2016年7月27日 下午8:34:47
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean match(String regex, Object obj) {
		if (obj == null)
			return false;
		String str = "";
		if (obj instanceof String || obj instanceof Integer || obj instanceof Double || obj instanceof Float
				|| obj instanceof Long) {
			str = obj.toString();
		} else if (obj instanceof Date) {
//			str = DateUtil.Date2Str((Date) obj);
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
}

