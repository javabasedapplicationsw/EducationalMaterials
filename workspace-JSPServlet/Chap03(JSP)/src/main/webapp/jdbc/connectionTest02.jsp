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
	<h2>JDBC Connect 테스트2</h2>
	<%
		String driver = application.getInitParameter("OracleDriver");
		String url = application.getInitParameter("OracleURL");
		String id = application.getInitParameter("OracleId");
		String pwd = application.getInitParameter("OraclePwd");
		
		JDBConnectionTest jdbc2 = new JDBConnectionTest(driver, url, id, pwd);
		jdbc2.close();
	%>
</body>
</html>