<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Model2 기반 게시판 - 목록 보기</title>
</head>
<body>
	<h2>Model2 기반 게시판 - 목록 보기</h2>
	
	<!-- 검색 폼 -->
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
	
	<table border="1" width= "90%">
		<!-- 각 컬럼 이름 -->
		<tr>
			<th width="10%">번호</th>
			<th width="*">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
			<th width="8%">첨부</th>
		</tr>
		
<c:choose>
	<c:when test="${empty boardLists }">								<!-- 게시물 없을 때 -->
		<tr>
			<td colspan="6" align="center">
				등록된 게시물이 없습니다.
			</td>
		</tr>		
	</c:when>
	<c:otherwise>														<!-- 게시물 있을 때 -->
		<c:forEach items="${boardLists }" var="row" varStatus="loop">
		<tr align="center">
			<td>	<!-- 번호 -->
				${map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index) }
			</td>
			<td align="left">	<!-- 제목(링크) -->
				<a href="../mvcboard/view.do?id=${row.id }">${row.title }</a>
			</td>
			<td>${row.name }</td>	<!-- 작성자 -->
			<td>${row.visitcount }</td>	<!-- 조회수 -->
			<td>${row.postdate }</td>	<!-- 작성일 -->
			<td>
				<c:if test="${not empty row.ofile }">
					<a href="../mvcboard/download.do?ofile=${row.ofile }&sfile=${row.sfile}&id=${row.id}">[Down]</a>				
				</c:if>				
			</td>	<!-- 첨부 파일 -->
		</tr>		
		</c:forEach>
	</c:otherwise>
</c:choose>		
	</table>	
	
	<!-- 아래 메뉴 (페이징 바로가기, 글쓰기) -->
	<table border="1" width="90%">
		<tr align="center">
			<td>${map.pagingData }</td>
			<td>
				<button type="button" onclick="location.href='../mvcboard/write.do'">글쓰기</button>
			</td>
		</tr>
	</table>				
</body>
</html>

























