<%@page import="kr.co.himedia.board.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	if (session.getAttribute("userId") == null) {	//session 영역에 "userId"라는 속성값이 있는지 확인 => null이면 로그인하지 않았다는 의미임
		JSFunction.alertLocation("로그인 후 이용해주십시오.", "./session02/loginForm.jsp", out);
		return;			// 실행을 멈춤
	}
%>