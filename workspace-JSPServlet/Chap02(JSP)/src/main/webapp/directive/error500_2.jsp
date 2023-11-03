<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="isErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>page 지시어 - errorPage, isErrorPage</title>
</head>
<body>
	<%
			int myAge = Integer.parseInt(request.getParameter("age")) + 10;
			out.println("10을 더한 결과는 " +myAge+ "입니다.");			
	%>
</body>
</html>