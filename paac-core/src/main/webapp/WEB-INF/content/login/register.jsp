<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//paac-core
	String path = request.getContextPath();
	//http://localhost:8080/paac-core/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>平台云-注册</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.4/themes/icon.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:400px 700px">
		<div class="easyui-panel" title="注册面板" style="width:400px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="register" method="post" action="<%=path%>/mainFrame/user/user_do_register.action">
	    	<table>
	    		<tr>
	    			<td>手机号或者邮箱:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="username" name="username" data-options="required:true,prompt:'请输入手机号或者邮箱'"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>登陆密码:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="password" name="password" data-options="required:true,prompt:'请输入登陆密码'"></input>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
	    </div>
	    </div>
	</div>
	</div>
	<script>
		function submitForm(){
			$('#register').form('submit');
		}
		function clearForm(){
			$('#register').form('clear');
		}
	</script>
</body>
</html>