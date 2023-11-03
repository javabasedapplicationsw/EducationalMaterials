<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%> 			<!-- 필요한 외부 클래스 임포트 -->
<%@page import="java.text.SimpleDateFormat"%>   
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>page 지시어 - import</title>
</head>
<body>
	<%
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = dateFormat.format(today);
		out.println("오늘 날짜 : " +todayStr);
	%>
</body>
</html>