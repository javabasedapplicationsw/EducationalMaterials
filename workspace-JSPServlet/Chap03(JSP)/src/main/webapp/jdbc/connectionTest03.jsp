<%@page import="kr.co.himedia.common.JDBConnectionTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JDBC</title>
</head>
<body>
	<h2>JDBC Connect 테스트3</h2>
	<%
		JDBConnectionTest jdbc3 = new JDBConnectionTest(application);
		jdbc3.close();
	%>
</body>
</html>