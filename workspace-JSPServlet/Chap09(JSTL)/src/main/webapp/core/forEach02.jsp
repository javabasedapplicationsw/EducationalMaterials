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
	<h4>향상된 for문 형태의 forEach 태그</h4>
	<%
		String[] rgba = {"Red", "Green", "Blue", "Black"};
	%>
	
	<c:forEach var="col" items="<%=rgba %>">
		<span style="color: ${col}">${col }</span>
	</c:forEach>
	
	<h4>향상된 for문 형태의 forEach 태그 - varStatus 속성 확인하기</h4>
	<table border="1">
		<c:forEach var="col" items="<%= rgba %>" varStatus="loop">
			<tr>
				<td>count : ${loop.count }</td>
				<td>index : ${loop.index }</td>
				<td>current: ${loop.current }</td>
				<td>first : ${loop.first }</td>
				<td>last : ${loop.last }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>



























