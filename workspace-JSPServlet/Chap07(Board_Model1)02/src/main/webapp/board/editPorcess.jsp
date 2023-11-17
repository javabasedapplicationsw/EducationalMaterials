<%@page import="kr.co.himedia.board.BoardDAO"%>
<%@page import="kr.co.himedia.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./isLoginedIn.jsp" %>

<%
	// 수정 내용 얻기
	String num = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	// DTO에 저장
	BoardDTO dto = new BoardDTO();
	dto.setNum(num);
	dto.setTitle(title);
	dto.setContent(content);
	
	BoardDAO dao = new BoardDAO(application);
	int updated = dao.updateBoard(dto);
	dao.close();
	
	// 성공/실패시 처리
	if (updated == 1) {
		//상세보기 페이지로 이동
		response.sendRedirect("view.jsp?num=" + dto.getNum());		
	}
	else {
		//실패시 이전페이지로 이동
		JSFunction.alertBack("수정하기에 실패했습니다.", out);		
	}
	
%>




























