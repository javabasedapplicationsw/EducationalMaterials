<%@page import="kr.co.himedia.common.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>page 영역</title>
</head>
<body>
	<h2>페이지 이동 후 page 영역의 속성값 읽기</h2>
	<%
		Object pageInteger = pageContext.getAttribute("pageInteger");
		Object pageString = pageContext.getAttribute("pageString");
		Object pageDTO = pageContext.getAttribute("pageDTO");	
	%>
	
	<ul>
		<li>Integer 객체 : <%= (pageInteger == null) ? "값 없음" : pageInteger %></li>
		<li>String 객체 : <%= (pageString == null) ? "값 없음" : pageString %></li>
		<li>Person 객체 : <%= (pageDTO == null) ? "값 없음" : ((PersonDTO)pageDTO).getName() %></li>
	</ul>
</body>
</html>









