<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value='/OrderServlet'/>" method="post">
	<input type="hidden" name="method" value="updateOrderByO_id"/>
		<table align="center" style="font-size : 30px " >
			<tr>
				<td >用户名 </td>
				<td>${sessionScope.sessionUser.u_name }</td>
			</tr>
			<tr>
				<td>订单号 ：</td>
				<td>${order.orderId }</td>
			</tr>
			<tr>
				<td>收件人名</td>
				<td><input type="text" name="receiveName" value="${order.receiveName }"/></td>
			</tr>
			<tr>
				<td>收件人电话</td>
				<td><input type="text" name="receivePhone" value="${order.receivePhone }"/></td>
			</tr>
			<tr>
				<td>收件人地址</td>
				<td><input type="text" name="receiveAdress" value="${order.receiveAdress }"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="修改"/></td>
				<td><a href="<c:url value='OrderServlet?method=myOrder'/>">返回</a></td>
			</tr>
		</table>
	</form>
</body>
</html>