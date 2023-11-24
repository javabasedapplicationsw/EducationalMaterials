<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL - url</title>
</head>
<body>
	<h4>url 태그로 링크 걸기</h4>
	<c:url var="url" value="/jstl/otherPage.jsp" >
		<c:param name="userParam1" value="hi" />
		<c:param name="userParam2">
			media
		</c:param>
	</c:url>
	<a href="${url }">otherPage.jsp 바로가기</a>
</body>
</html>