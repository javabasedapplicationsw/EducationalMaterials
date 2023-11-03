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
	<a href="requestWebInfo.jsp?himedia=Chenho&hi=GoodMorning">GET 방식으로 전송 요청</a>
	<br/>
	<form action="requestWebInfo.jsp" method="post"  >	<!-- POST 방식으로 요청 -->
		영어 : <input type="text" name="himedia" value="media" /><br/>
		한글 : <input type="text" name="hi" value="잘가세요" /><br/>
		<input type="submit" value="POST 방식 전송">
	</form>
	<br/>
	<h2> HTTP 요청 헤더 정보 읽기</h2>
	<a href="requestHeader.jsp">요청 헤더 정보 읽기</a>
	
	<br/>
	<h2>클라이언트의 요청 매개변수 읽기</h2>
	<form method="post" action="requestParameter.jsp">
		아이디 : <input type="text" name="id" value="" /><br/>
		성별 : 
		<input type="radio" name="gender" value="man" />남자
		<input type="radio" name="gender" value="woman" checked="checked" />여자<br/>		
		관심사항 :
		<input type="checkbox" name="favorite" value="eco" /> 경제
		<input type="checkbox" name="favorite" value="pol" /> 정치
		<input type="checkbox" name="favorite" value="ent" /> 연예<br/>
		자기소개:
		<textarea rows="4" cols="30" name="intro">
		</textarea><br/>	
		<input type="submit" value="전송하기"><br/>
	</form>
</body>
</html>












