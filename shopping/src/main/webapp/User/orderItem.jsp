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
						<span class="spanEmpty">订单上没有东西</span>
					</td>
				</tr>
			</table>  
		</c:when>
		<c:otherwise>
		<div  align="center">${o_id } 号订单</div>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#efeae5">
					<td>商品名</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
					<td>操作</td>
				</tr>	
	
				<c:forEach items="${pb.beanList }" var="orderItem" varStatus="status">
					<tr>					
						<td>${orderItem.good.gName }</td>
						<td>${orderItem.g_quantity }</td>
						<td>${orderItem.good.gPrice }</td>
						<td>${orderItem.g_quantity * orderItem.good.gPrice }</td>
						<td>
						<a href="<c:url value='/OrderItemServlet?method=eidtOrderItem&oId=${o_id }&quantity=${orderItem.g_quantity + 1 }&orderItem_id=${orderItem.orderitem_id }'/>">增加</a>
						<a href="<c:url value='/OrderItemServlet?method=eidtOrderItem&oId=${o_id }&quantity=${orderItem.g_quantity + 1 }&orderItem_id=${orderItem.orderitem_id }'/>">减少</a>
						</td>
						<td><a href="<c:url value='/OrderItemServlet?method=deleteOrderItem&orderItem_id=${orderItem.orderitem_id }&oId=${o_id }'/>">删除该商品</a></td>
					</tr>
				</c:forEach>
				
				<tr>
					<td><a href="<c:url value=''/>">下单</a></td>
					<td><a href="<c:url value='/OrderServlet?method=delete&Oid=${o_id}'/>">取消订单</a></td>
					<td><a href="<c:url value='/OrderServlet?method=findByO_id&Oid=${o_id }'/>">修改订单信息</a></td>
				</tr>
			</table>
	
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty pb.beanList}">
		<div align="center"><%@include file="/User/pager.jsp" %></div>
	</c:if>

  </body>
</html>