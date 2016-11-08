<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>后台管理页面</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.4/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.4/themes/icon.css">
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/util/DateHelper.js"></script>
	</head>
	<body class="easyui-layout">
		<!-- 头部 -->
		<div data-options="region:'north',border:false,href:'<%=path%>/mainFrame/manage/manage_to_mainFrame_top.action'" style="height:110px;background-image: url(<%=path%>/images/mainFrame/top_bg.gif);
					background-repeat: repeat-x;background-position: center top;padding:5px;"></div>
		<!-- 中部 -->
		<div id="mainFrameCenter" data-options="region:'center',border:false,href:'' " style="height:100%;width:100%"></div>
		<!-- 底部 -->
		<div data-options="region:'south',split:true" 
			 style="color:black;background-image: url(<%=path%>/images/mainFrame/bottom_bg.gif);
					background-repeat: repeat-x;background-position: center top;text-align:center;padding:5px;height:30px;overflow: hidden;">
			<div>©2016.02-<span id="copyrightTime"></span> Platform As a Cloud(www.shiyuanyun.com) All rights reserved.</div>
		</div>
	</body>
	<script type="text/javascript">
		var path = '<%=path%>' ;
	</script>
	<script type="text/javascript" src="<%=path%>/js/mainFrame.js"></script>
</html>