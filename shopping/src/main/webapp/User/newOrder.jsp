<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/OrderServlet?method=addOrder'/>" method="post">
		<table align="center" style="font-size : 30px " >
			<tr>
				<td >用户名 </td>
				<td>${sessionScope.sessionUser.u_name }</td>
			</tr>
			<tr>
				<td>收件人名</td>
				<td><input type="text" name="receiveName"/></td>
			</tr>
			<tr>
				<td>收件人电话</td>
				<td><input type="text" name="receivePhone"/></td>
			</tr>
			<tr>
				<td>收件人地址</td>
				<td><input type="text" name="receiveAdress"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="产生订单"/></td>
				<td><input type="reset" value="重新填写"/></td>
			</tr>
		</table>
	</form>
</body>
</html>