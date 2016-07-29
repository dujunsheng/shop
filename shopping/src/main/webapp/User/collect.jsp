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
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<span class="spanEmpty">收藏夹中为空</span>
					</td>
				</tr>
			</table>  
		</c:when>
		<c:otherwise>
		<div  align="center">我的收藏夹</div>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr align="center" bgcolor="#efeae5">
					<td colspan="2">名称</td>
					<td>操作</td>
					<td>操作</td>
				</tr>	
	
				<c:forEach items="${pb.beanList }" var="collection" varStatus="status">
					<tr align="center" class="row${status.index mod 3 }">					
						<td align="left" width="200px" colspan=2>
						    <a  href="<c:url value='/GoodServlet?method=findByGid&Gid=${collection.good.gId  }'/>"><span>${collection.good.gName }</span></a>
						</td>
						<td>
							<a href="<c:url value='/CollectServlet?method=delete&Gid=${collection.good.gId}'/>">删除</a>
						</td>
						<td>
							<a href="<c:url value='/GoodServlet?method=findByGid&Gid=${collection.good.gId}'/>">查询</a>
						</td>
					</tr>
					<br>
				</c:forEach>
	
			</table>
	
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty pb.beanList}">
		<div align="center"><%@include file="/User/pager.jsp" %></div>
	</c:if>

  </body>
</html>