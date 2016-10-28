package com.codelibrary.javaee.intercepter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.codelibrary.javaee.annotation.MethodException;
import com.codelibrary.javaee.entry.hibernate.SystemLog;
import com.codelibrary.javaee.utils.Constant;



@Aspect
public class SystemLogAspect {
	@Pointcut("@annotation(com.codelibrary.javaee.intercepter.MethodException)")
	public void methodCachePointcut() {}

	@Around("methodCachePointcut() && @annotation(methodException)")
	public Object methodCacheHold(ProceedingJoinPoint joinPoint, MethodException methodException) {
		Object result = null;
		String remark = "";
		long state = 1;
		try {
			remark = methodException.remark();
			result = joinPoint.proceed();
		} catch (Exception e1) {//捕获异常进这里
			state = 2;
			e1.printStackTrace();
		} catch (Throwable e2) {//抛异常进这里
			state = 2;
			e2.printStackTrace();
		}
		if (state == 1) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String code=(String) request.getAttribute(Constant.KEY_LOG_ERROR);
			if(StringUtils.isNotEmpty(code)){
				remark="state:"+code;
				JSONObject str = JSONObject.parseObject(remark);
				remark=str.toString();
			}else{
				if (remark.equals("json"))
					remark = "{\"json\":\"suc\"}";
				else
					remark = remark + "_suc";
			}
		} else {
			if (remark.equals("json"))
				remark = "{\"json\":\"err\"}";
			else
				remark = remark + "_err";
		}
		if (remark.length() > 4){
			printWriter(remark); //返回前台
		}
		if(StringUtils.isNotEmpty(methodException.description())){
			doBeAfter(joinPoint, state, methodException.description()); //写入数据库
		}
		return result;
	}
	public void doBeAfter(ProceedingJoinPoint joinPoint, long state, String description) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		String ip = request.getRemoteAddr();
		String code=(String) request.getAttribute(Constant.KEY_LOG_SUCCESS);
		request.removeAttribute(Constant.KEY_LOG_SUCCESS);
		//接下来是入库操作
		SystemLog log = new SystemLog() ;
	}
	protected void printWriter(String str) {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 不加这句，在谷歌浏览器中将不能正常识别json数据<谷歌浏览器会自动给数据加上pre标签>
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
