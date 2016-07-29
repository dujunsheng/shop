<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/book/list.js'/>"></script>
	<style type="text/css">
		li {float: left; width: 240px; list-style:none;height: 319px; line-height: 18px; position: relative; border-bottom: solid 1px #e5e5e5; }
		img {width: 150px; height:150px}
		li div {margin-bottom:1px;margin-left: 10px;}
	</style>
  </head>
  
  <body>

<ul>
<c:forEach items="${pb.beanList }" var="goods">
  <li>
  <div class="inner">
    <a class="pic" href="<c:url value='/GoodServlet?method=findByGid&gId=${goods.gId }'/>"><img src="<c:url value='/${good.gPicture }'/>" border="0"/></a>
	<p><a id="goodName" title="${good.gName }" href="<c:url value='/BookServlet?method=findByBid&bid=${good.gId }'/>">${good.gName }</a></p>
	<p class="name">
		<span class="name">名称：${goods.gName }</span>
	</p>
	<p class="price">
		<span class="price_n">价格：${goods.gPrice }</span>
	</p>
	<p class="quantity">
		<span class="quantity">数量：${goods.gQuantity }</span>
	</p>
  </div>
  </li>
</c:forEach>

</ul>

<div style="float:left; width: 100%; text-align: center;">
	<hr/>
	<br/>
	<%@include file="/User/pager.jsp" %>
</div>

  </body>
 
</html>