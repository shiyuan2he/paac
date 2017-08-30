package com.hsy.paac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.controller
 * @date 30/08/2017 6:13 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
@RequestMapping("/sso")
public class SsoController {
    @RequestMapping(value="/login")
    public String login(){
        return "/sso/login";
    }
}
