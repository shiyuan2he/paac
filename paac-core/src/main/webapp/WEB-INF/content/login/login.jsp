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
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/easyui/jquery.easyui1.4.5.min.js"></script>
</head>
<body>
	<div style="margin:400px 700px">
		<div class="easyui-panel" title="登陆面板" style="width:400px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="login" method="post" action="<%=basePath%>manage/user/user_do_login.action">
	    	<table>
	    		<tr>
	    			<td colspan="2" align="right">
						<a href="<%=basePath%>manage/user/user_to_login_register.action">尚未注册?</a>	    			
	    			</td>
	    		</tr>
			<tr>
	    			<td>登陆用户:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="username" name="username" 
	    					data-options="required:true,
	    								 prompt:'请输入用户名'
	    								 "
	    				></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>登陆密码:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" id="password" name="password" 
	    					data-options="required:true,prompt:'请输入密码'"></input>
	    			</td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">登陆</a>
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