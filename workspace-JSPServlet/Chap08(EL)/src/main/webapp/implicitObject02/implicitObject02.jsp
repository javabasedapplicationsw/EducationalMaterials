<%@page import="kr.co.himedia.common.CookieMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieMain.makeCookie(response, "ELCookie", "블프좋아요", 10);
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>EL - 내장 객체(쿠키, 헤더 정보값 읽기)</title>
</head>
<body>
	<h3>쿠키값 읽기</h3>
	<ul>
		<li>ELCookie값 : ${cookie.ELCookie.value }</li>	
	</ul>

	<h3>HTTP 헤더 읽기</h3>
	<ul>
		<li>host : ${header.host }</li>
		<li>User-Agent: ${header['User-Agent'] }</li>
		<li>cookie : ${header.cookie }</li>
	</ul>
	
	<h3>컨텍스트 초기화 매개변수 읽기</h3>
	<ul>
		<li>OracleDriver : ${initParam.OracleDriver }</li>
	</ul>
	
	<h3>컨텍스트 루트 경로 읽기</h3>
	<ul>
		<li>${pageContext.request.contextPath }</li>
	</ul>
</body>
</html>




