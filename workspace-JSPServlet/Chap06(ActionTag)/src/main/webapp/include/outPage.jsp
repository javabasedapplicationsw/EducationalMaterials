<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>외부파일</title>
</head>
<body>
	<h2>외부파일</h2>
	<% String himedia = "굿바이 2023, 웰컴 2024"; %>
	
	<ul>
		<li>page 영역 : <%= pageContext.getAttribute("pAttr") %> </li>
		<li>request 영역 : <%= request.getAttribute("rAttr") %> </li>
	</ul>
</body>
</html>