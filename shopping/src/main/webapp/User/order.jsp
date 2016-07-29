<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>cartlist.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>	
	<link rel="stylesheet" type="text/css" href="<c:url value='/User/css/pager.css'/>" />
    
	<style type="text/css">
		.row1{
			background-color: #F0FFF0;
		}
	</style>
  </head>
  <body>

	<c:choose>
		<c:when test="${empty pb.beanList }">
			<table width="95%" align="center" cellpadding="0" cellspacing="0" style="line-height:50px;">
				<tr>
					<td>
						<span class="spanEmpty">订单为空</span>
					</td>
				</tr>
			</table>  
		</c:when>
		<c:otherwise>
		<div  align="center">我的订单</div>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#efeae5">
					<td>订单编号</td>
					<td>产生订单时间</td>
					<td>总金额</td>
					<td>订单状态</td>
					<td>收件人</td>
					<td>电话</td>
					<td>地址</td>
					<td>操作</td>
					<td>操作</td>
					<td>操作</td>
				</tr>	
	
				<c:forEach items="${pb.beanList }" var="order" varStatus="status">
					<tr>					
						<td>${order.orderId }</td>
						<td>${order.creatTime }</td>
						<td>${order.total }</td>
						<td>${order.orderStatus }</td>
						<td>${order.receiveName }</td>
						<td>${order.receivePhone }</td>
						<td>${order.receiveAdress }</td>
						<td>
							<a href="<c:url value='/CardServlet?method=findItem&orderId=${order.orderId }'/>">添加购物车商品</a>
						</td>
						<td>
							<a href="<c:url value='/OrderServlet?method=delete&Oid=${order.orderId}'/>">删除</a>
						</td>
						<td>
							<a href="<c:url value='/OrderItemServlet?method=findByOid&oId=${order.orderId}'/>">查询订单详细信息</a>
						</td>
	
					</tr>
				</c:forEach>
	
			</table>
	
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty pb.beanList}">
		<div align="center"><%@include file="/User/pager.jsp" %></div>
	</c:if>

  </body>
</html>