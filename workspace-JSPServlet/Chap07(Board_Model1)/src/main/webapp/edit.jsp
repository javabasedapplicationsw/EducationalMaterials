<%@page import="kr.co.himedia.board.BoardDTO"%>
<%@page import="kr.co.himedia.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./isLoginedIn.jsp" %>    
<%
	String num = request.getParameter("num");			//일련번호 받기
	BoardDAO dao = new BoardDAO(application);			//DAO 생성
	BoardDTO dto = dao.selectView(num);					//게시물 가져오기 
	
	String userId = session.getAttribute("userId").toString();
	if (!userId.equals(dto.getId())) {			// 본인인지 확인하기 
		JSFunction.alertBack("작성자 본인만 수정할 수 있습니다.", out);
	}
	dao.close();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>수정하기</title>
  <script type="text/javascript">
	function validateForm(form) {
		if (form.title.value == "") {
			alert("제목을 입력하세요.");
			form.title.focus();
			return false;
		}
		if (form.content.value == "") {
			alert("내용을 입력하세요.");
			form.content.focus();
			return false;
		}		
	}   
  </script>
</head>
<body>
	<jsp:include page="./common/headerLink.jsp" />		<!-- 공통 링크 -->
	<h2> 게시판 - 수정 하기</h2>
	<form action="editPorcess.jsp" name="editFrm" method="post" onsubmit="return validateForm(this);">
		<input type="hidden" name="num" value="<%= dto.getNum()  %>" />
		<table border="1" width="90%">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" style="width: 90%;" value="<%= dto.getTitle() %>" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>





























