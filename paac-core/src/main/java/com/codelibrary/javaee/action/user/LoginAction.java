package com.codelibrary.javaee.action.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codelibrary.javaee.annotation.MethodException;
import com.codelibrary.javaee.entry.bean.UserInfoBean;
import com.codelibrary.javaee.entry.hibernate.User;
import com.codelibrary.javaee.service.user.IUserService;
import com.codelibrary.javaee.utils.AnnotationUtil;
import com.codelibrary.javaee.utils.Constant;
import com.hsy.codebase.utils.javase.bean.BeanHelper;
import com.hsy.codebase.utils.javase.string.StringHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @path paac-core/com.codelibrary.javaee.action.user.LoginAction.java
 * @description <p>登陆</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月8日 下午2:51:41
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
@Controller
public class LoginAction extends ActionSupport {
	/**
	 * @description <p>请再次输入属性描述</p>
	 */
	private static final long serialVersionUID = 1L;
	private static Logger _logger = Logger.getLogger(LoginAction.class);
	@Autowired
	private IUserService userService ;
	private String tip ;
	private User user ;
	
	
	
	/**
	 * 
	 * @return
	 * @returnType String
	 * @description
	 *		<p>用户登录</p>
	 */
	@MethodException(remark="select",description="登录系统")
	public String do_login() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest() ;
		HttpServletResponse response = ServletActionContext.getResponse() ;
		if(null!=user&&StringHelper.isNotNullOrEmpty(user.getPassword())&&StringHelper.isNotNullOrEmpty(user.getPassword())){
			user = userService.login(user.getUsername(),user.getPassword()) ;
			if(BeanHelper.isNotNull(user)){
				//向session里面放入用户基本信息
				setSessionBean(user) ;
				request.setAttribute(Constant.KEY_LOG_SUCCESS, user.getId());
				//动态修改日志
				AnnotationUtil.updateAnnotation(this.getClass(), "do_login", "description", "用户["+user.getUsername()+"]登陆系统成功！");
				setTip(request.getContextPath() + response.encodeURL("/mainFrame/manage/manage_toMainView.action"));
				return "doLoginOk" ;
			}	
		}else{
			request.setAttribute(Constant.KEY_LOG_ERROR, user.getUsername());
			AnnotationUtil.updateAnnotation(this.getClass(), "do_login", "description", "用户["+user.getUsername()+"]登陆系统失败！");
			_logger.error("【--用户登录--】传递参数失败：用户名或者用户密码传递失败。。");
		}
		return "failure";
	}
	/**
	 * @description <p>推出登录</p>
	 * @return
	 * @returnType String
	 * 方法名:logout
	 * 类名:UserAction
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 下午5:18:21
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	@MethodException(remark = "",description = "退出登录")
	public String logout() {
		Map<String,Object> mapSession = ActionContext.getContext().getSession() ;
		HttpServletRequest request = ServletActionContext.getRequest() ;
		UserInfoBean uesrinfo = (UserInfoBean) mapSession.get("userinfo") ;
		if (uesrinfo != null) {
			mapSession.remove("userinfo") ;
			request.getSession().invalidate();
			request.setAttribute(Constant.KEY_LOG_SUCCESS, "退出登录");
		}
		return "logout_ok";
	}
	/**
	 * @description <p>将用户信息放入session中</p>
	 * @param user2
	 * @returnType void
	 * 方法名:setSessionBean
	 * 类名:UserAction
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 下午2:12:58
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	private void setSessionBean(User user2) {
		Map<String,Object> mapSession = ActionContext.getContext().getSession() ;
		UserInfoBean userinfo = new UserInfoBean() ;
		userinfo.setUserId(user2.getId());
		userinfo.setUsername(user2.getUsername());
		mapSession.put("userinfo", userinfo);
	}
	/**
	 * 
	 * @description <p>注册</p>
	 * @return
	 * @returnType String
	 * 方法名:do_register
	 * 类名:UserAction
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月27日 下午1:22:22
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	@MethodException(remark="add",description="用户注册")
	public String do_register(){
		if(!BeanHelper.isNull(userService)){
			boolean flag = userService.register(user.getUsername(),user.getPassword()) ;
			if(flag){
				return "doRegisterOk" ;
			}
		}
		return "failure" ;
	}
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}


