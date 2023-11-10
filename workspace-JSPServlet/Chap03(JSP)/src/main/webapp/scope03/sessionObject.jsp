<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> lists = new ArrayList<>();
	lists.add("이순신");
	lists.add("신사임당");
	
	session.setAttribute("lists", lists);
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>session 영역</title>
</head>
<body>
	<h2>페이지 이동 후 session 영역의 속성 읽기</h2>
	<a href="sessionObject02.jsp">sessionObject02.jsp 바로가기</a>
</body>
</html>