package com.hsy.paac.urms.base.intercepter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsy.paac.urms.base.annotation.MethodException;
import com.hsy.paac.urms.base.entry.hibernate.SystemLog;
import com.hsy.paac.urms.base.service.base.IBaseService;
import com.hsy.paac.urms.base.utils.Constant;
import com.hsy.paac.urms.base.entry.bean.UserInfoBean;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.hsy.paac.base.utils.javase.string.StringHelper;
@Aspect
public class SystemLogAspect {
	@Autowired
	private IBaseService baseService ;
	@Pointcut("@annotation(com.hsy.paac.urms.base.annotation.MethodException)")
	public void methodCachePointcut() {}

	@Around("methodCachePointcut() && @annotation(methodException)")
	public Object methodCacheHold(ProceedingJoinPoint joinPoint,MethodException methodException) {
		Object result = null;
		String remark = "";
		String state = "1";//默认正常
		String exceptionMsg = "" ;
		try {
			remark = methodException.remark();
			result = joinPoint.proceed();//action  return
		} catch (Exception e1) {//捕获异常进这里
			state = "catch Exception:"+e1.getMessage();
			exceptionMsg = e1.getMessage();
			e1.printStackTrace();
		} catch (Throwable e2) {//抛异常进这里
			state = "throw Exception:"+e2.getMessage();
			exceptionMsg = e2.getMessage();
			e2.printStackTrace();
		}
		/**
		 * @author heshiyuan	@date 2016年11月8日 下午6:12:44
		 * @description <p>如果注解上的remark为空，添加返回tip，否则返回action里的tip</p>
		 */
		if(StringHelper.isNullOrEmpty(remark)){
			JSONObject str = null ;
			if (StringHelper.equals("1", state)) {//没有异常
				//HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				HttpServletRequest request = ServletActionContext.getRequest() ;
				//先获取错误code，看是否业务处理失败
				String code=(String) request.getAttribute(Constant.KEY_LOG_ERROR);
				if(StringHelper.isNotNullOrEmpty(code)){//action处理业务失败
					remark="tip:"+code;
				}else{//action 处理业务成功
					remark="tip:success";
				}
			} else {//捕获或者抛出异常
				remark="tip:"+state;
			}
			str = JSONObject.parseObject(remark);
			remark=str.toString();
			if (remark.length() > 4){
				try {
					printWriter(remark);//返回前台
				} catch (Exception e3) {
					state = "throw Exception:"+e3.getMessage();
					exceptionMsg = e3.getMessage();
					e3.printStackTrace();
				}
			}
		}
		/**
		 * @author heshiyuan	@date 2016年11月8日 下午6:12:44
		 * @description <p>如果注解上的description非空，日志入库</p>
		 */
		if(StringHelper.isNotNullOrEmpty(methodException.description())){
			if(StringHelper.isNotNullOrEmpty(exceptionMsg)){
				doBeAfter(joinPoint, state, methodException.description()+";捕获异常，异常信息："+exceptionMsg);
			}else{
				doBeAfter(joinPoint, state, methodException.description()); //写入数据库
			}
		}
		return result;
	}
	public void doBeAfter(ProceedingJoinPoint joinPoint, String state, String description) {
		HttpServletRequest request = ServletActionContext.getRequest() ;
		HttpSession session = request.getSession();
		UserInfoBean userinfo = (UserInfoBean)session.getAttribute("userinfo") ;
		String ip = request.getRemoteAddr();
		//String ip =JarUtils.getIP(request);
		String code=(String) request.getAttribute(Constant.KEY_LOG_SUCCESS);
		request.removeAttribute(Constant.KEY_LOG_SUCCESS);
		if(null != userinfo){
			//接下来是入库操作
			SystemLog log = new SystemLog() ;
			log.setCreateTime(new Date());
			log.setCreateUserId(userinfo.getUserId());
			log.setCreateUserName(userinfo.getUsername());
			log.setIsDel("0");
			if(StringHelper.isNotNullOrEmpty(code)){
				log.setModuleId(code);
			}else{
				log.setModuleId("default");
			}
			log.setObjectId(state);
			log.setRequestIP(ip);
			log.setRequestMethod(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()+ "()");
			log.setRequestRemark(description);
			log.setRequestTime("4000");
			log.setRequestUrl(request.getRequestURI());
			baseService.save(log) ;
		}
	}
	protected void printWriter(String str) throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		// 不加这句，在谷歌浏览器中将不能正常识别json数据<谷歌浏览器会自动给数据加上pre标签>
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(str);
	}
}
