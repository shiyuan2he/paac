/**
 * @description <p></p>
 * @path paac-core/com.codelibrary.javaee.utils.HttpHelper.java
 * @time 2016年8月29日 下午9:37:17
 * @github 
 *     https://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.hsy.paac.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class HttpHelper {
	/**
	 * 
	 * @description <p>将request请求里的变量封装成map</p>
	 * @param request
	 * @param paras
	 * @return
	 * @returnType Map<String,Object>
	 * 方法名:setSerachByRequest
	 * 类名:HttpHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年8月29日 下午9:40:35
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static Map<String,Object> requestParametersToMap(HttpServletRequest request,String paras) {
		Enumeration<?> enu = request.getParameterNames();
		Map<String,Object> map = new HashMap<String,Object>();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			// 判斷是否在字符串中存在
			if (paras.indexOf(paraName.trim()) == -1) {
				if (StringUtils.isNotEmpty(request.getParameter(paraName))) {
					map.put(paraName, request.getParameter(paraName));
				}
			}
		}
		return map;
	}
}

