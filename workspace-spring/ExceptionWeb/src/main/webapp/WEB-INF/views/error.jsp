<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
</head>
<body>
	<h1>예외가 발생했습니다.</h1>
	발생한 예외 : ${ex }
	<ol>
		<c:forEach items="${ex.stackTrace }" var="i">
			<li>${i.toString() }</li>
		</c:forEach>
	</ol>
</body>
</html>