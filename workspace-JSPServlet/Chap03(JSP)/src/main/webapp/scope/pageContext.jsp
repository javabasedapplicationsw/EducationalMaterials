<%@page import="kr.co.himedia.common.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 속성 저장 */
	pageContext.setAttribute("pageInteger", 2023);
	pageContext.setAttribute("pageString", "페이지 영역의 문자열 저장");
	pageContext.setAttribute("pageDTO", new PersonDTO("이순신", 30));
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>page 영역</title>
</head>
<body>
	<h2>page 영역의 속성값 읽기</h2>
	<%
		int pageInteger = (Integer)pageContext.getAttribute("pageInteger");
		String pageString = (String)pageContext.getAttribute("pageString");
		PersonDTO pageDTO = (PersonDTO)pageContext.getAttribute("pageDTO");
	%>
	
	<ul>
		<li>Integer 객체 : <%= pageInteger %></li>
		<li>String 객체 : <%= pageString %></li>
		<li>Person 객체 : <%= pageDTO.getName() %>, <%= pageDTO.getAge() %></li>
	</ul>
	
	<h2>include된 파일에서 page 영역 읽어오기</h2>
	<%@ include file="pageInclude.jsp" %>
	
	<h2>페이지 이동 후 page 영역 읽어오기</h2>
	<a href="pageContext02.jsp">pageContext02.jsp 바로가기</a>
</body>
</html>
























