package com.codelibrary.javaee.intercepter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.codelibrary.javaee.annotation.MethodException;
import com.codelibrary.javaee.entry.bean.UserInfoBean;
import com.codelibrary.javaee.entry.hibernate.SystemLog;
import com.codelibrary.javaee.service.base.IBaseService;
import com.codelibrary.javaee.utils.Constant;
import com.codelibrary.javaee.utils.JarUtils;
import com.hsy.codebase.utils.javase.string.StringHelper;



@Aspect
public class SystemLogAspect {
	@Autowired
	private IBaseService baseService ;
	@Pointcut("@annotation(com.codelibrary.javaee.intercepter.MethodException)")
	public void methodCachePointcut() {}

	@Around("methodCachePointcut() && @annotation(methodException)")
	public Object methodCacheHold(ProceedingJoinPoint joinPoint,MethodException methodException) {
		Object result = null;
		String remark = "";
		long state = 1;
		String exceptionMsg = "" ;
		try {
			remark = methodException.remark();
			result = joinPoint.proceed();
		} catch (Exception e1) {//捕获异常进这里
			state = 2;
			exceptionMsg = e1.getMessage();
			e1.printStackTrace();
		} catch (Throwable e2) {//抛异常进这里
			state = 2;
			exceptionMsg = e2.getMessage();
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
			if (remark.equals("json")){
				remark = "{\"json\":\"err\"}";
			} else {
				remark = remark + "_err";
			}
		}
		if (remark.length() > 4){
			printWriter(remark); //返回前台
		}
		if(StringHelper.isNotNullOrEmpty(methodException.description())){
			if(StringHelper.isNotNullOrEmpty(exceptionMsg)){
				doBeAfter(joinPoint, state, methodException.description()+";捕获异常，异常信息："+exceptionMsg);
			}else{
				doBeAfter(joinPoint, state, methodException.description()); //写入数据库
			}
		}
		return result;
	}
	public void doBeAfter(ProceedingJoinPoint joinPoint, long state, String description) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		UserInfoBean userinfo = (UserInfoBean)session.getAttribute("userinfo") ;
		//String ip = request.getRemoteAddr();
		String ip =JarUtils.getIP(request);
		String code=(String) request.getAttribute(Constant.KEY_LOG_SUCCESS);
		request.removeAttribute(Constant.KEY_LOG_SUCCESS);
		if(null != userinfo){
			//接下来是入库操作
			SystemLog log = new SystemLog() ;
			log.setCreateTime(new Date());
			log.setCreateUserId(userinfo.getUserId());
			log.setCreateUserName(userinfo.getUsername());
			log.setIsDel(0);
			if(StringHelper.isNotNullOrEmpty(code)){
				log.setModuleId(code);
			}
			log.setObjectId(String.valueOf(state));
			log.setRequestIP(ip);
			log.setRequestMethod(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()+ "()");
			log.setRequestRemark(description);
			//log.setRequestTime("");
			log.setRequestUrl(request.getRequestURI());
			baseService.save(log) ;
		}
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
