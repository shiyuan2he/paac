<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>平台云-登陆</title>
</head>
<body>
	<div style="padding:3px 2px;border-bottom:1px solid #ccc">登陆</div>
	<form id="ff" action="form1_proc.php" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input name="name" type="text"></input></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input name="email" type="text"></input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登陆"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>