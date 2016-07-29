<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

<style type="text/css">
	body {
		background: #15B69A;
		margin: 0px;
		color: #ffffff;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">网上商城</h1>
<div style="font-size: 10pt; line-height: 10px;">

<%-- 根据用户是否登录，显示不同的链接 --%>
<c:choose>
	<c:when test="${empty sessionScope.sessionUser }">
		  <a href="<c:url value='/User/userLoad.jsp'/>" target="_parent">用户登录</a> 
		  <a href="<c:url value='/User/regist.jsp'/>" target="_parent">新用户注册</a>
	</c:when>
	<c:otherwise>
		      用户：${sessionScope.sessionUser.u_name }&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/CollectServlet?method=myCollect&pc=1'/>" target="body">我的收藏夹</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/CardServlet?method=myCard&pc=1' />" target="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href=<c:url value='/OrderServlet?method=myOrder&pc=1'/> target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href=<c:url value='/User/pwd.jsp'/> target="body">修改个人信息</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href=<c:url value='/User/upassword.jsp'/> target="body">修改密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">退出</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
</div>
