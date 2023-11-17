<%@page import="kr.co.himedia.board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.himedia.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// DAO 생성하면 DB에 연결
	BoardDAO dao = new BoardDAO(application);

	// 사용자가 입력한 검색 조건을 Map에 저장
	Map<String, Object> param = new HashMap<>();
	String searchField = request.getParameter("searchField");
	String searchWord = request.getParameter("searchWord");
	if (searchWord != null) {
		param.put("searchField", searchField);
		param.put("searchWord", searchWord);
	}
	
	//게시물 수 확인
	int totalCount = dao.selectCount(param);
	//out.println(totalCount);
	List<BoardDTO> boardLists = dao.selectList(param);			// 게시물 목록 받기
	
	dao.close();				// DB 연결 닫기
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시판_모델1방식</title>
</head>
<body>
	<jsp:include page="../common/headerLink.jsp" />			<!-- 공통 링크 -->
	<h2>게시글 목록 보기</h2>
	<!-- 검색폼 -->
	<form action="" method="get">
		<table border="1" width="90%">
			<tr>
				<td align="center">
					<select name="searchField">
						<option value="title" >제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchWord" />
					<input type="submit" value="검색하기" />
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 게시물 목록 (표) -->
	<table border="1" width= "90%">
		<!-- 각 컬럼 이름 -->
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
		<!-- 목록 내용 -->
		<%
			//게시물이 하나도 없을때
			if (boardLists.isEmpty()) {
		%>
			<tr>
				<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
			</tr>
		<%
			}
			else {
				//게시물이 있을 때
				int virtualNum = 0;			// 화면상에서의 게시물 번호 
				for (BoardDTO dto : boardLists) {
					
					virtualNum = totalCount--;		// 전체 검색된 게시물 수에서 1씩 감소
		%>
				<tr align="center">
					<td><%=virtualNum %></td>		<!-- 게시물 번호 -->
					<td align="left">				<!-- 제목(하이퍼링크) -->
						<a href="view.jsp?num=<%= dto.getNum() %>"><%=dto.getTitle() %></a>
					</td>
					<td align="center"><%= dto.getId() %></td>				<!-- 작성자 아이디 -->
					<td align="center"><%= dto.getVisitCount() %></td>		<!-- 조회수 -->
					<td align="center"><%= dto.getPostdate() %></td>		<!-- 작성일 -->
				</tr>
		
		<%
				}
			}
		%>
	</table>
	<!-- 글쓰기 버튼 -->
	<table border="1" width="90%">
		<tr align="right">
			<td><button type="button" onclick="location.href='write.jsp';">글쓰기</button></td>
		</tr>
	</table>
</body>
</html>



























