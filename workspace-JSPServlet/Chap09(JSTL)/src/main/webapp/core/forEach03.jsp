<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedList"%>
<%@page import="kr.co.himedia.jstl.PersonDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL - 향상된 for문</title>
</head>
<body>
	<h4>List 컬랙션 생성</h4>
	<%
		List<PersonDTO> lists = new LinkedList<>();
		lists.add(new PersonDTO("이순신", 10));
		lists.add(new PersonDTO("신사임당", 20));
		lists.add(new PersonDTO("이방원", 30));
	%>
	<c:set var="lists" value="<%= lists %>" />
	
	<c:forEach var="list" items="${lists }">
		<ul>
			<li>이름 : ${list.name }, 나이 : ${list.age }</li>
		</ul>
	</c:forEach>
	
	<h4>Map 컬랙션 생성</h4>
	<%
		Map<String, PersonDTO> maps = new HashMap<>();
		maps.put("1st", new PersonDTO("이성계", 30));
		maps.put("2nd", new PersonDTO("정도전", 40));
		maps.put("3rd", new PersonDTO("남은", 50));
	%>
	<c:set var="maps" value="<%=maps %>" />
	<c:forEach var="map" items="${maps }">
		<ul>
			<li>Key => ${map.key } <br/>
				Value => 이름 : ${map.value.name }, 나이 : ${map.value.age }
			 </li>
		</ul>
	</c:forEach>
</body>
</html>


































