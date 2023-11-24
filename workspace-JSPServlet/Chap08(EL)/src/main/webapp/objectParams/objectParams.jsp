<%@page import="kr.co.himedia.el.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>EL - 객체 매개변수</title>
</head>
<body>
	<%
		request.setAttribute("PersonObject", new PersonDTO("이순신", 33));
		request.setAttribute("StringObject", "아듀 2023년");
		request.setAttribute("IntegerObject", new Integer(2024));
	%>
	<jsp:forward page="ObjectResult.jsp">
		<jsp:param value="2025" name="firstNum"/>
		<jsp:param value="2026" name="secondNum"/>
	</jsp:forward>
</body>
</html>