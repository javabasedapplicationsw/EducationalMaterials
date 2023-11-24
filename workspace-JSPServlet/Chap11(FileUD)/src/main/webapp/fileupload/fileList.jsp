<%@page import="java.net.URLEncoder"%>
<%@page import="kr.co.himedia.fileupload.HiFileDTO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.himedia.fileupload.HiFileDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>FileUpload 목록보기</title>
</head>
<body>
	<h2>DB에 등록된 파일 목록 보기</h2>
	<a href="fileUploadMain.jsp">파일등록</a>
	<%
		HiFileDAO dao = new HiFileDAO();
		List<HiFileDTO> fileLists = dao.hiFileList();
		dao.close();
	%>
	
	<table border="1">
		<tr>
			<th>No</th><th>제목</th><th>카테고리</th>
			<th>원본 파일명</th><th>저장된 파일명</th><th>작성일</th><th></th>
		</tr>
		<%
			for (HiFileDTO h : fileLists) {
		%>
				<tr>
					<td><%= h.getId() %></td>
					<td><%= h.getTitle() %></td>
					<td><%= h.getCategory()%></td>
					<td><%= h.getOfile()%></td>
					<td><%= h.getSfile()%></td>
					<td><%= h.getPostdate()%></td>
					<td><a href="download.jsp?oName=<%= URLEncoder.encode(h.getOfile(), "UTF-8") %>&sName=<%= URLEncoder.encode(h.getSfile(), "UTF-8") %>">[다운로드]</a></td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>






















