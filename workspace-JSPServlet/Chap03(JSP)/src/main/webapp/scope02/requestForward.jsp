<%@page import="kr.co.himedia.common.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>request 영역</title>
</head>
<body>
	<h2>포워드로 전달된 페이지</h2>
	<h4>request.jsp 파일의 리퀘스트 영역 속성 읽기</h4>
	<%
		PersonDTO rPersonDTO = (PersonDTO)request.getAttribute("requestPersonDTO");
	%>	
	<ul>
		<li>String 객체 : <%= request.getAttribute("requestString") %></li>
		<li>PersonDTO 객체 : <%= rPersonDTO.getName() %>, <%= rPersonDTO.getAge() %></li>
	</ul>	
	
	<h4>매개변수로 전달된 값 출력</h4>
	<%
		request.setCharacterEncoding("UTF-8");
		out.println(request.getParameter("param1"));
		out.println(request.getParameter("param2"));
	%>
</body>
</html>













