package com.hsy.codebase.utils.javase.util;
/**
 * 
 * @description 
 *		<p>随机数工具类</p>
 * @time 2016年7月6日 下午10:25:40
 * @github 
 * 		http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * @returnType long
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class RandomHelper {
	
	/**
	 * 
	 * @description 
	 *		<p>当前毫秒数</p>
	 * @time 2016年7月6日 下午10:25:40
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType long
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static long curTimeGenerator(){
		return System.currentTimeMillis();
	}
	/**
	 * 
	 * @description 
	 *		<p>生成24位全球唯一标识ID主键-PAAC14776347668456433687</p>
	 * @time 2016年7月6日 下午10:35:19
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType String
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	synchronized public static String IDGenerateValue(final long lastTimestamp){
		final StringBuffer idValue = new StringBuffer() ;
		long timestamp  = curTimeGenerator();
		while (timestamp <= lastTimestamp) {
			 timestamp = curTimeGenerator();
		}
		idValue.append("PAAC").append(timestamp).append(Math.round(Math.random()*10000000)) ;
		return idValue.toString();
	}
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(IDGenerateValue(System.currentTimeMillis()));
	}
}
