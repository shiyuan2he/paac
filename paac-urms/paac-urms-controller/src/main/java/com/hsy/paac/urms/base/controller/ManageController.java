package com.hsy.paac.urms.base.controller;

import com.hsy.paac.base.common.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @description <p></p>
 * @author heshiyuan
 * @date 04/09/2017 3:53 PM
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
@Controller
@RequestMapping("/manage")
public class ManageController extends BaseController {

	private static Logger _logger = Logger.getLogger(ManageController.class.getName());

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(){
		return "/manage/index";
	}
}