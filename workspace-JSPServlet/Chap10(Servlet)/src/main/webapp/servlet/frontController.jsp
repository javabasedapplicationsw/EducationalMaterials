<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>여러 요청 처리</title>
</head>
<body>
	<h3>한 번의 매핑으로 여러 요청 처리하기</h3>
	${result }
	<ol>
		<li>URI : ${uri }</li>
		<li>요청명 : ${commandStr }</li>
	</ol>
	
	<ul>
		<li><a href="../servlet/join.one">회원가입</a></li>
		<li><a href="../servlet/login.one">로그인</a></li>
		<li><a href="../servlet/board.one">게시판</a></li>
	</ul>
</body>
</html>