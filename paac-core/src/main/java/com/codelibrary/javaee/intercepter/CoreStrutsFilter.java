package com.codelibrary.javaee.intercepter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class CoreStrutsFilter extends StrutsPrepareAndExecuteFilter {
	private static Logger logger = Logger.getLogger(CoreStrutsFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		//HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getRequestURI();
		logger.info("拦截器拦截的地址：" + url);
		/*if (request.getSession().getAttribute("userinfo") == null) {
			response.sendRedirect(request.getContextPath() + response.encodeURL("/website/main.jsp"));
			return;
		}*/
		try {
			super.doFilter(req, res, chain);
			/**
			 * @not sure <p>搞明白doFilter两个参数和三个参数的区别</p>
			 * chain.doFilter(req, res);
			 */
		} catch (Exception ee) {
			logger.info("struts拦截器捕获到异常，异常信息：" + ee.getMessage());
		}
	}
}
