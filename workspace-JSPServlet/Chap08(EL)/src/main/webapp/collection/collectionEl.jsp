<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.himedia.el.PersonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>EL - 컬렉션</title>
</head>
<body>
	<h2>List 컬렉션</h2>
	<%
		List<Object> oList = new ArrayList<>();
		oList.add("이순신");
		oList.add(new PersonDTO("신사임당", 20));
		pageContext.setAttribute("oList", oList);
	%>
	
	<ul>
		<li>0번째 요소 : ${oList[0] } </li>
		<li>1번째 요소 : ${oList[1].name }, ${oList[1].age }</li>
		<li>2번째 요소 : ${oList[2] }</li>			<!-- null 상태임. 예외를 발생시키지 않음 -->
	</ul>
	
	<%
		Map<String, String> map = new HashMap<>();
		map.put("하늘", "맑고 청명함");
		map.put("hi", "media");
		pageContext.setAttribute("map", map);
	%>
	
	<ul>
		<li>영문 key : ${map["hi"] }, ${map['hi'] }, ${map.hi }</li>
		<li>한글 key : ${map["하늘"] }, ${map['하늘'] }, <%-- ${map.하늘 } --%></li>		<!-- 키가 한글일때 인식이 안되어 에러남 -->
	</ul>
</body>
</html>

























