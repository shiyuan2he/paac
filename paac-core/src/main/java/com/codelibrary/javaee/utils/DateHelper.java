/**
 * @path paac-core/com.codelibrary.javaee.utils/DateHelper.java	
 * @time May 2, 2016 10:25:31 AM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.codelibrary.javaee.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	/**
	 * @description 
	 *		<p></p>
	 * @time 2016年10月16日 下午9:23:02
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType String
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static String dateToString(Date time){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
	    String ctime = formatter.format(time); 
	    return ctime; 
	} 
}

