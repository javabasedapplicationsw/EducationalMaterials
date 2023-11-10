<%@page import="kr.co.himedia.common.DBConnPoolTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JNDI</title>
</head>
<body>
	<h2>커넥션 풀 테스트</h2>
	<%
		DBConnPoolTest pool = new DBConnPoolTest();
		pool.close();
	%>
	
</body>
</html>