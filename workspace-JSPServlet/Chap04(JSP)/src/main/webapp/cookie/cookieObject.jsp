<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Cookie</title>
</head>
<body>
	<h2>쿠키 설정</h2>
	<%
		Cookie cookie = new Cookie("myCookie", "뻬뺴로 데이 호갱님");	//쿠키 생성
		cookie.setPath(request.getContextPath());					//경로를 컨택스트 루트로 설정
		cookie.setMaxAge(3600);										//유지 기간을 1시간으로 설정
		response.addCookie(cookie);									//응답 헤더에 쿠키 추가 
	%>
	
	<h2>쿠키 설정 직후 쿠키값 확인</h2>
	<%
		Cookie[] cookies = request.getCookies();					//요청 헤더의 모든 쿠키 얻기 
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();					//쿠키 이름 얻기
				String cookieValue = c.getValue();					//쿠키 값 얻기 
			}
			
			//화면에 출력
			//
		}
	%>
</body>
</html>








