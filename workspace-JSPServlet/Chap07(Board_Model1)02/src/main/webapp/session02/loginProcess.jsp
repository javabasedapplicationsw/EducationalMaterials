<%@page import="kr.co.himedia.login.MemberDTO"%>
<%@page import="kr.co.himedia.login.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 로그인 폼으로부터 받은 아이디와 패스워드
	String userId = request.getParameter("user_id");
	String userPwd = request.getParameter("user_pw");
	
	// web.xml 에서 가져온 DB 연결 정보
	String oracleDriver = application.getInitParameter("OracleDriver");
	String oracleURL = application.getInitParameter("OracleURL");
	String oracleId = application.getInitParameter("OracleId");
	String oraclePwd = application.getInitParameter("OraclePwd");
	
	// DAO를 통해 회원 정보 확인
	MemberDAO dao = new MemberDAO(oracleDriver, oracleURL, oracleId, oraclePwd);
	MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
	dao.close();

	// 로그인 성공에 따른 처리
	if (memberDTO.getId() != null) {
		//로그인 성공
		session.setAttribute("userId", memberDTO.getId());
		session.setAttribute("userName", memberDTO.getName());
		response.sendRedirect("loginForm.jsp");
		
	} else {
		//로그인 실패
		request.setAttribute("loginErrMsg", "로그인 오류입니다.");
		request.getRequestDispatcher("loginForm.jsp").forward(request, response);
	}
%>






















