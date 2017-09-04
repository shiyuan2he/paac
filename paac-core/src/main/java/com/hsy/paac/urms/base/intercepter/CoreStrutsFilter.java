package com.hsy.paac.urms.base.intercepter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
public class CoreStrutsFilter extends StrutsPrepareAndExecuteFilter {
	private static Logger logger = Logger.getLogger(CoreStrutsFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		//HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getRequestURI();
		logger.info("struts拦截器过滤的请求地址：" + url);
		/**
		 * 以下地址放行
		 * "/paac-core/manage/user/user_to_login_register.action"
		 * "/paac-core/WEB-INF/content/login/register.jsp"
		 * "/paac-core/css/easyui/themes/default/images/blank.gif"
		 * "/paac-core/manage/user/user_do_register.action"
		 * "/paac-core/WEB-INF/content/login/login.jsp"
		 */
		/*if (!(url.contains("register.action")||url.contains("register.jsp")||url.contains("easyui")||url.contains("login.jsp")||url.contains("login.action"))
				&&request.getSession().getAttribute("userinfo") == null) {
			logger.error("用户未登录，此请求将重定向到后台登陆页面。。。");
			response.sendRedirect(request.getContextPath() + response.encodeURL("/manage/user/user_to_login_login.action"));
			return;
		}*/
		try {
//			chain.doFilter(request, response);
			super.doFilter(req, res, chain);
			/**
			 * @notSure <p>搞明白doFilter两个参数和三个参数的区别</p>
			 * chain.doFilter(req, res);
			 */
		} catch (Exception ee) {
			logger.error("struts拦截器捕获到异常，异常信息：" + ee.getMessage());
		}
	}
	
}
