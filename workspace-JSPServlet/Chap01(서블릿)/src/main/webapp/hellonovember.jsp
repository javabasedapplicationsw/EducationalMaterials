<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String requestName = request.getParameter("name");
	String servletName = config.getServletName();
	
	
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>첫번째 JSP 개발</title>
</head>
<body>
	<h1><%= requestName %>님 안녕하세요.</h1>
	<h2>저는 <%=servletName %>입니다.</h2>
</body>
</html>