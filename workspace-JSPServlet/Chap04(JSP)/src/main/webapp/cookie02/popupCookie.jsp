<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String chkVal = request.getParameter("noToday");		/* noToday 매개변수의 값 얻기  */
	
	if (chkVal != null && chkVal.equals("1")) {				/* 값이 "1"이면 */
		Cookie cookie = new Cookie("PopupClose", "off");	/* 쿠키 생성 */
		cookie.setPath(request.getContextPath());			/* 경로 설정 */
		cookie.setMaxAge(60*60*24);							/* 유지 기간 설정 */
		response.addCookie(cookie);							/* 응답 객체에 추가 */
		out.println("쿠키 : 오늘은 그만 보기");				
	}

%>