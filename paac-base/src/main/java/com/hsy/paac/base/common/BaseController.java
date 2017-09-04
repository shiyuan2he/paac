package com.hsy.paac.base.common;

import com.hsy.paac.base.bean.ResponseBodyBean;
import com.hsy.paac.base.enums.ConstantsEnum;
import com.hsy.paac.base.util.PropertiesFileUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.common
 * @date 31/08/2017 11:23 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BaseController {
    private static Logger _logger = Logger.getLogger(BaseController.class.getName()) ;
    /**
     * 统一异常处理
     * @param request
     * @param response
     * @param exception
     */
    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        _logger.error("统一异常处理：",exception);
        request.setAttribute("ex", exception);
        if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            request.setAttribute("requestHeader", "ajax");
        }
        // shiro没有权限异常
        /*if (exception instanceof UnauthorizedException) {
            return "/403.jsp";
        }*/
        // shiro会话已过期异常
        /*if (exception instanceof InvalidSessionException) {
            return "/error.jsp";
        }*/
        return "/error";
    }

    /**
     * 返回jsp视图
     * @param path
     * @return
     */
    public static String jsp(String path) {
        return path.concat(".jsp");
    }

    /**
     * 返回thymeleaf视图
     * @param path
     * @return
     */
    public static String thymeleaf(String path) {
        String folder = PropertiesFileUtil.getInstance().get("app.name");
        return "/".concat(folder).concat(path).concat(".html");
    }
    /**
     * @description <p>通用失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:12 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> failure() {
        return new ResponseBodyBean<>(false, ConstantsEnum.RETURN_COMMON_FAILURE.getCode(), ConstantsEnum.RETURN_COMMON_FAILURE.getMsg());
    }
    /**
     * @description <p>定制失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> failure(String code , String errorInfo){
        return new ResponseBodyBean<>(false, code,errorInfo) ;
    }
    /**
     * @description <p>定制失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> failure(String errorInfo){
        return new ResponseBodyBean<>(false, ConstantsEnum.RETURN_COMMON_FAILURE.getCode(), ConstantsEnum.RETURN_COMMON_FAILURE.getMsg()) ;
    }
    /**
     * @description <p>通用失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:12 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> success(){
        return new ResponseBodyBean<>(true, ConstantsEnum.RETURN_COMMON_SUCCESS.getCode(), ConstantsEnum.RETURN_COMMON_SUCCESS.getMsg()) ;
    }
    /**
     * @description <p>定制失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected ResponseBodyBean<Object> success(Object obj){
        return new ResponseBodyBean<>(true, ConstantsEnum.RETURN_COMMON_SUCCESS.getCode(),obj) ;
    }
}
