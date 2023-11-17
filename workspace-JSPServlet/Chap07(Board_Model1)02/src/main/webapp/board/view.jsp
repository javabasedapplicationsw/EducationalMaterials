<%@page import="kr.co.himedia.board.BoardDTO"%>
<%@page import="kr.co.himedia.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");			// 상세보기 페이지 일련번호 받기
	
	BoardDAO dao = new BoardDAO(application);			// DAO 생성
	dao.updateVisitCount(num);							// 조회수 증가
	BoardDTO dto = dao.selectView(num);					// 게시물 가져오기
	dao.close();
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시글 상세보기 화면</title>
  <script type="text/javascript">
  	function deletePost() {
		let confirmed = confirm("정말로 삭제하겠습니까?");
		
		if(confirmed) {
			let form = document.detailView;				// name이 "detailView"인 폼 선택
			form.method = "post";						// 전송방식
			form.action = "deleteProcess.jsp";			// 전송 경로
			form.submit();								// 폼값 전송
		}
	}
  </script>
</head>
<body>
	<jsp:include page="../common/headerLink.jsp" />		<!-- 공통 링크 -->
	<h2> 게시판 - 상세 보기 화면</h2>
	<form name="detailView">
		<input type="hidden" name="num" value="<%= num %>" />
		<table border="1" width="90%">
			<tr>
				<td>번호</td>
				<td><%= dto.getNum()  %></td>
				<td>작성자</td>
				<td><%= dto.getName() %></td>				
			</tr>
			<tr>
				<td>작성일</td>
				<td><%= dto.getPostdate()  %></td>
				<td>조회수</td>
				<td><%= dto.getVisitCount() %></td>				
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><%= dto.getTitle() %></td>
			</tr>	
			<tr>
				<td>내용</td>
				<td colspan="3" height="100">
					<%= dto.getContent().replace("\r\n", "<br/>") %>
				</td>
			</tr>		
			<tr>
				<td colspan="4" align="center">
					<%
						if (session.getAttribute("userId") != null && session.getAttribute("userId").toString().equals(dto.getId())) {
					%>
						<button type="button" onclick="location.href='edit.jsp?num=<%= dto.getNum()%>'">수정하기</button>
						<button type="button" onclick="deletePost();">삭제하기</button>
					<%
						}
					%>
						<button type="button" onclick="location.href='list.jsp';">목록보기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>



















