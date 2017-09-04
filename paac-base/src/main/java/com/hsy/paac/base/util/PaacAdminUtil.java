package com.hsy.paac.base.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path paac/com.hsy.paac.util
 * @date 2017/8/31 22:10
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PaacAdminUtil implements InitializingBean, ServletContextAware {
    private static final Logger _logger = Logger.getLogger(PaacAdminUtil.class.getName()) ;
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        _logger.info("===== 开始解压paac-admin =====");
        String version = PropertiesFileUtil.getInstance("paac-admin-client").get("paac.admin.version");
        _logger.info("paac-admin.jar 版本: "+version);
        String jarPath = servletContext.getRealPath("/WEB-INF/lib/paac-admin-" + version + ".jar");
        _logger.info("paac-admin.jar 包路径: "+jarPath);
        String resources = servletContext.getRealPath("/") + "/resources/paac-admin";
        _logger.info("paac-admin.jar 解压到: "+resources);
        JarUtil.decompress(jarPath, resources);
        _logger.info("===== 解压paac-admin完成 =====");
    }
}
