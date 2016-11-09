<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	
</style>
<div>
    <div><a href='javascript:void(0);' onclick='javascript:void(0);'><img src=""/></a></div>
    <div>
       <ul>
       <c:forEach var="tree" items="${requestScope.treeList}">
	      <li class="" onclick="javascript:setHeadClass(this)"><a href="javascript:void(0);" onclick="javascript:void(0);')">
	      	${tree.menuName}
	      </a></li>
       </c:forEach>
       </ul>
    </div>
</div>
