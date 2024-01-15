<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="loginout" value="${sessionScope.id==null ? 'Login' : 'Logout' }" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/login/login' : '/login/logout' }" />


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<c:url value='/resources/css/menu.css' />" />
	<title>게시판 리스트</title>
</head>
<body>
	<div id="menu">
		<ul>
			<li id="logo">HiCheonho</li>
			<li><a href="<c:url value='/' />">Home</a></li>
			<li><a href="<c:url value='/board/list' />">Board</a></li>
			<li><a href="<c:url value='${loginoutlink }' />">${loginout }</a></li>
			<li><a href="<c:url value='/register/add' />">SignUp</a></li>
		</ul>
	</div>	
	<div style="text-align: center;">
		<h2>건강 데이터는 당신만의 것으로 안전하게 보호</h2>
		<h2>당신의 심장을 예의 주시</h2>
		<h2>혈중 산소 포화도 측정. 살아 숨쉬는 혁신</h2>
		<h2>순간의 감정과 그날의 기분을 기록</h2>
		<h2>뛰어난 내구성 덕분에 언제든 전력을 다해 운동</h2>
	</div>
</body>
</html>



















