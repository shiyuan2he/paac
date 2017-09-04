/**
 * @path paac-core/com.codelibrary.javaee.utils.JarUtils.java
 * @description <p>请在这里输入类的描述</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年10月31日 上午10:59:36
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
package com.hsy.paac.urms.base.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @path paac-core/com.codelibrary.javaee.utils.JarUtils.java
 * @description <p>请在这里输入类的描述</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年10月31日 上午10:59:36
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
public class JarUtils {
	/**
	 * 
	 * @description <p>获取ip地址</p>
	 * @param request
	 * @return
	 * @returnType String
	 * 方法名:getIP
	 * 类名:JarUtils
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 上午10:59:50
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String getIP(HttpServletRequest request){
		 String ip = request.getHeader("X-Forwarded-For");  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("Proxy-Client-IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("WL-Proxy-Client-IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_CLIENT_IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getRemoteAddr();  
	            }  
	        } else if (ip.length() > 15) {  
	            String[] ips = ip.split(",");  
	            for (int index = 0; index < ips.length; index++) {  
	                String strIp = (String) ips[index];  
	                if (!("unknown".equalsIgnoreCase(strIp))) {  
	                    ip = strIp;  
	                    break;  
	                }  
	            }  
	        }  
	        return ip;  
	}
}


