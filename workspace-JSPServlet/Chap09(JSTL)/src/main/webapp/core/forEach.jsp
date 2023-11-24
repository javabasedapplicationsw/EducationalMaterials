<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL - forEach </title>
</head>
<body>
	<h4>일반 for문 형태의 forEach 태그</h4>
	<c:forEach var="i" begin="1" end="3" step="1">
		<p>반복 ${i} 입니다. </p>
	</c:forEach>
	
	<h4>varStatus 속성 확인</h4>
	<table border="1">
		<c:forEach var="i" begin="3" end="5" varStatus="loop">
			<tr>
				<td>count : ${loop.count }</td>
				<td>index : ${loop.index }</td>
				<td>current : ${loop.current }</td>
				<td>first : ${loop.first }</td>
				<td>last : ${loop.last }</td>
			</tr>
		</c:forEach>
	</table>
	
	<h4>1에서 100까지 정수 중 홀수의 합</h4>
	<c:forEach var="j" begin="1" end="100">
		<c:if test="${ j mod 2 ne 0 }">
			<c:set var="sum" value="${sum + j }" />
		</c:if>
	</c:forEach>
	1-100사이의 정수 중 홀수의 합은? ${sum }
</body>
</html>

















