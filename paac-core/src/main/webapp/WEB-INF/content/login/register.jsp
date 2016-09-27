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
	<title>平台云-登陆</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/easyui/themes/icon.css">
	<script type="text/javascript" src="<%=path%>/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:400px 700px">
		<div class="easyui-panel" title="注册面板" style="width:400px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="register" method="post" action="<%=path%>/manage/user/user_login.action">
	    	<table>
	    		<tr>
	    			<td>登陆用户:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="username" name="username" 
	    					data-options="required:true,prompt:'请输入登陆用户名'"
	    				></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="realname" name="realname" 
	    					data-options="required:true,
	    								 prompt:'请输入登陆用户名'
	    								 "
	    				></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>昵称:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="nickname" name="nickname" 
	    					data-options="required:true,
	    								 prompt:'请输入登陆用户名'
	    								 "
	    				></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>登陆密码:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="password" name="password" 
	    					data-options="required:true,prompt:'请输入登陆密码'"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>重复密码:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="repassword" 
	    					data-options="prompt:'请输入登陆密码'"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>联系方式:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="phone" name="user.address.phone"
	    					data-options="required:true,prompt:'请输入密码'"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>出生日期:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="birth" name="birth" 
	    					data-options="required:true,prompt:'请输入密码'"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>身份证号:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="certNo" name="certNo" 
	    					data-options="required:true,prompt:'请输入密码'"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>邮编:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="postCode" name="user.address.postCode" 
	    					data-options="required:true,prompt:'请输入密码'"></input>
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
			$('#login').form('submit');
		}
		function clearForm(){
			$('#login').form('clear');
		}
	</script>
</body>
</html>