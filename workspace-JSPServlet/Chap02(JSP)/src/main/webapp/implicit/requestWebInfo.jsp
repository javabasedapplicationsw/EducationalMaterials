<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>내장 객체 - request</title>
</head>
<body>
	<h2>클라이언트와 서버의 환경정보 읽기</h2>
	<ul>
		<li>데이터 전송 방식 : <%= request.getMethod() %></li>
		<li>URL : <%= request.getRequestURL() %></li>
		<li>URI : <%= request.getRequestURI() %></li>
		<li>프로토콜 : <%= request.getProtocol() %></li>
		<li>서버 포트 : <%= request.getServerPort() %></li>
		<li>서버명 : <%= request.getServerName() %></li>
		<li>클라이언트 IP 주소 : <%= request.getRemoteAddr() %></li>	<!-- localhost로 접속했을때는 클라이언트 IP 주소는 0:0:0:0:0:0:0:1 -->
		<li>쿼리스트링 : <%= request.getQueryString() %></li>
		<li>전송된 값1 : <%= request.getParameter("himedia") %></li>
		<li>전송된 값2 : <%= request.getParameter("hi") %></li>
	</ul>
</body>
</html>