<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书详细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/User/css/book/goodDesc.css'/>">
	<script src="<c:url value='/jsps/js/book/desc.js'/>"></script>
  </head>
  
  <body>
  <div class="divBookName">${goods.gName}</div>
  <div>
    <img align="top" src="<c:url value='/${goods.gPicture}'/>" class="img_image_w"/>
    <div class="divBookDesc">
	    <ul>
	    	<li>商品编号：${goods.gId }</li>
	    	<li>分       类: ${goods.gQuantity } </li>
	    </ul>
		<hr class="hr1"/>
		<table>
			<tr>
				<td>
					价       格：${goods.gPrice }
				</td>
				<td>
					剩余数量：${goods.gQuantity }
				</td>
			</tr>
			
		</table>
		<div class="divForm">
  			<a href="<c:url value='CollectServlet?method=add&gId=${goods.gId} '/>">添加收藏</a>
  			&nbsp;&nbsp;
  			<a href="<c:url value='/CardServlet?method=addCard&goodId=${goods.gId }'/>" >添加进购物车</a>
  		</div> 
 
	</div>
  </div>
  </body>
</html>