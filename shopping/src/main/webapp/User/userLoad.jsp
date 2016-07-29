<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
	<div class="main">
	<h1 class="title">商城</h1>
	  <div>
	    <div class="login1">
	      <div class="login2">
            <div class="loginTopDiv">
              <span class="loginTop">用户登录</span>
            </div>
            <div>
              <form target="_top" action="<c:url value='/UserServlet'/>" method="post" id="loginForm">
                <input type="hidden" name="method" value="login" />
                  <table>
                    <tr>
                      <td width="50"></td>
                      <td><label class="error" id="msg">${msg }</label></td>
                    </tr>
                    <tr>
                      <td width="50">用户名</td>
                      <td><input class="input" type="text" name="u_name" id="loginname" value="${user.u_name }"/></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginnameError" class="error"></label></td>
                    </tr>
                    <tr>
                      <td>密　码</td>
                      <td><input class="input" type="password" name="u_pw" id="loginpass" value="${user.u_name }"/></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginpassError" class="error"></label></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td align="left">
                        <input type="submit" id="submit" value="登录"/>
                      </td>
                    </tr>	
                              <tr>
                      <td height="20">&nbsp;</td>
                      <td></td>
                    </tr>
                     <tr>
                      <td>&nbsp;</td>
                      <td align="left">
                        <a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">新用户注册</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="<c:url value='/jsps/main.jsp'/>" target="_parent">返回首页</a>
                      </td>
                    </tr>		
                                      																
                 </table>
              </form>
            </div>
          </div>
        </div>
      </div>
	</div>
	 
  </body>
</html>
