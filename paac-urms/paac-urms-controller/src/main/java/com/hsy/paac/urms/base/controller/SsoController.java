package com.hsy.paac.urms.base.controller;

import com.hsy.paac.base.bean.ResponseBodyBean;
import com.hsy.paac.base.bean.SessionBean;
import com.hsy.paac.base.common.BaseController;
import com.hsy.paac.urms.base.model.TUrmsSystemExample;
import com.hsy.paac.urms.rpc.api.TUrmsSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

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
@Api(value = "单点登录管理", description = "单点登录管理")
public class SsoController extends BaseController {
    // 全局会话key
    private final static String PAAC_UPMS_SERVER_SESSION_ID = "paac-upms-server-session-id" ;
    @Autowired
    TUrmsSystemService urmsSystemService;
    @ApiOperation(value = "认证中心首页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws Exception {
        String appid = request.getParameter("appid");
        String backurl = request.getParameter("backurl");
        if (StringUtils.isBlank(appid)) {
            throw new RuntimeException("无效访问！");
        }
        // 判断请求认证系统是否注册
        TUrmsSystemExample upmsSystemExample = new TUrmsSystemExample();
        upmsSystemExample.createCriteria().andNameEqualTo(appid);
        int count = urmsSystemService.countByExample(upmsSystemExample);
        if (0 == count) {
            throw new RuntimeException(String.format("未注册的系统:%s", appid));
        }
        return "redirect:/rso/login?backurl=" + URLEncoder.encode(backurl, "utf-8");
    }


    @ApiOperation(value = "登录")
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "/sso/login" ;
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBodyBean<Object> login(String username, String password, HttpServletRequest request){
        SessionBean sessionBean = (SessionBean)request.getSession().getAttribute(PAAC_UPMS_SERVER_SESSION_ID);
        // 判断是否登陆
        if(null == sessionBean){
            if(StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)){
                request.getSession().setAttribute(PAAC_UPMS_SERVER_SESSION_ID,new SessionBean(username,password));
                return super.success();
            }
        }
        return super.success();
    }
}
