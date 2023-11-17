<%@page import="kr.co.himedia.board.BoardDAO"%>
<%@page import="kr.co.himedia.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./isLoginedIn.jsp" %>    
<%
	String num = request.getParameter("num");		//일련번호 얻기
	
	BoardDTO dto = new BoardDTO();
	BoardDAO dao = new BoardDAO(application);
	dto = dao.selectView(num);						//주어진 일련번호에 해당하는 기존 게시물 얻기
	
	//로그인한 사용자 ID 얻기
	String sessionId = session.getAttribute("userId").toString();
	
	int delResult = 0;
	//작성자가 본인인지 여부 확인
	if (sessionId.equals(dto.getId())) {
		//작성자 본인
		dto.setNum(num);
		delResult = dao.deleteBoard(dto);			//삭제
		
		dao.close();
		
		// 성공/실패처리
		if (delResult == 1) {
			//성공시 목록페이지로 이동
			JSFunction.alertLocation("삭제되었습니다.", "list.jsp", out);
		} else {
			//실패시 이전 페이지로 이동
			JSFunction.alertBack("삭제에 실패했습니다.", out);
		}				
	}
	else {
		//작성자가 본인이 아니라면 이젠 페이지로 이동
		JSFunction.alertBack("본인만 삭제할 수 있습니다.", out);
		
		return;
	}
%>















