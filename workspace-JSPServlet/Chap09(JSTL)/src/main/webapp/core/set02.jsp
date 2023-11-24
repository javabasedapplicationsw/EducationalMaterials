<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.himedia.jstl.PersonDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL - set</title>
</head>
<body>
	<h4>List 컬렉션 이용</h4>
	<%
		List<PersonDTO> pList = new ArrayList<>();
		pList.add(new PersonDTO("이방원", 50));
		pList.add(new PersonDTO("세종대왕", 30));
	%>
	<c:set var="personList" value="<%=pList %>" scope="request" />
	<ul>
		<li>이름 : ${requestScope.personList[0].name }</li>
		<li>나이 : ${personList[0].age }</li>
	</ul>
	
	<h4>Map 컬렉션 이용</h4>
	<%
		Map<String, PersonDTO> pMap = new HashMap<>();
		pMap.put("personObj1", new PersonDTO("이성계", 60));
		pMap.put("personObj2", new PersonDTO("정도전", 55));
	%>
	<c:set var="personMap" value="<%= pMap %>" scope="request"/>
	<ul>
		<li>이름 : ${requestScope.personMap.personObj2.name }</li>
		<li>나이 : ${personMap.personObj2.age }</li>
	</ul>
</body>
</html>






















