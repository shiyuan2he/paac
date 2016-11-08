<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//paac-core
	String path = request.getContextPath();
	//http://localhost:8080/paac-core/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>平台云-登陆</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.4/themes/icon.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/util/JsUtilHelper.js"></script>
</head>
<body>
	<div style="margin:400px 700px">
		<div class="easyui-panel" title="登陆面板" style="width:400px;">
		<div style="padding:10px 60px 20px 60px">
	    <form>
	    	<table>
	    		<tr>
	    			<td colspan="2" align="right">
						<a href="<%=basePath%>/mainFrame/user/user_to_login_register.action">尚未注册?</a>	    			
	    			</td>
	    		</tr>
				<tr>
	    			<td>登陆用户:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="username" name="user.username" 
	    					data-options="required:true,
	    								 prompt:'请输入用户名'
	    								 "
	    				></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>登陆密码:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="password" name="user.password" 
	    					data-options="required:true,prompt:'请输入密码'"></input>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:loginJS.login();">登陆</a>
	    </div>
	    </div>
	</div>
	</div>
	<script type="text/javascript">
		var path = '<%=path%>' ;
	</script>
	<script type="text/javascript" src="<%=path%>/js/login/login.js"></script>
</body>
</html>