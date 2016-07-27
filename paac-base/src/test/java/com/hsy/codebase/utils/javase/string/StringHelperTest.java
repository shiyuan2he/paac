package com.hsy.codebase.utils.javase.string;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-base/com.hsy.codebase.utils.javase.string
 * @time 2016年7月27日 下午7:43:16
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class StringHelperTest {
	private Logger  _logger = Logger.getLogger(StringHelperTest.class) ;
	@Test
	public void testIsNullOrEmpty() {
		_logger.info("\"\":"+StringHelper.isNullOrEmpty(""));
		_logger.info("\" \":"+StringHelper.isNullOrEmpty(" "));
		_logger.info("null:"+StringHelper.isNullOrEmpty(null));
	}
	
	@Test
	public void testIsNotNullOrEmpty() {
		_logger.info("\"\":"+StringHelper.isNotNullOrEmpty(""));
		_logger.info("\" \":"+StringHelper.isNotNullOrEmpty(" "));
		_logger.info("null:"+StringHelper.isNotNullOrEmpty(null));
	}
}

