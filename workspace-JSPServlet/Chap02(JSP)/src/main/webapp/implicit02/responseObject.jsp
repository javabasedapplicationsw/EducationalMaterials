<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>내장 객체 - response</title>
</head>
<body>
	<h2>로그인</h2>
	<%
		String loginErr = request.getParameter("loginErr");
		if(loginErr != null) out.print("로그인 실패");
	%>	
	<form action="responseLogin.jsp" method="post">
		아이디 : <input type="text" name="user_id" /><br/>
		패스워드 : <input type="password" name="user_pwd" /><br/>
		<input type="submit" value="로그인" />
	</form>
	
	<br/>
	<h2> HTTP 응답 헤더 추가하기</h2>
	<form action="responseHeader.jsp" method="get">
		날짜 : <input type="text" name="add_date" value="2023-11-03 12:30" /><br/>
		숫자 : <input type="text" name="add_int" value="305" /><br/>
		문자 : <input type="text" name="add_str" value="이순신"/><br/>
		<input type="submit" value="응답 헤더 추가 & 출력" />
	</form>
	
</body>
</html>



























