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
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/main.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="世远云平台 | 平台项目 | 云服务平台" />
</head>
<body class="container">
	<div class="header">
			<div><ul><li>首页</li><li>旅行</li><li>读书</li><li>编程</li></ul></div>
		</div>
		<div class="top">
			<div class="top-content"><ul><li class="top-logo">logo</li><li class="top-search"><input type="text" value="全站搜索" title="全站搜索" /><input type="button" value="搜索" title="搜索" /></li></ul></div>
		</div>
		<div class="content">
			<div class="contentA"></div>
			<div class="contentB"></div>
			<div class="contentC"></div>
			<div class="contentD"></div>
		</div>
		<div class="bottom">
			<div>©2016-now Platform As a Cloud(127.0.0.1) All rights reserved.</div>
		</div>
</body>
</html>