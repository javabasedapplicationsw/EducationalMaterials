<%@page import="kr.co.himedia.board.BoardDAO"%>
<%@page import="kr.co.himedia.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./isLoginedIn.jsp" %>

<%
	//form 입력값 받기
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	//form 입력값을 DTO 객체에 저장
	BoardDTO dto = new BoardDTO();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setId(session.getAttribute("userId").toString());
	
	//DAO객체 생성해서 DB에 DTO 저장
	BoardDAO dao = new BoardDAO(application);
	int iResult = dao.insertBoard(dto);
	
	dao.close();
	
	// 글쓰기 성공 or 실패
	if (iResult == 1)
		response.sendRedirect("list.jsp");
	else 
		JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
%>













