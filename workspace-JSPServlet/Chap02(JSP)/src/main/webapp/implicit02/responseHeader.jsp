<%@page import="java.util.Collection"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 응답 헤더에 추가할 값 받기
	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	long add_date = s.parse(request.getParameter("add_date")).getTime();
	int add_int = Integer.parseInt(request.getParameter("add_int"));
	String add_str = request.getParameter("add_str");
	
	// 응답 헤더에 값 추가하기 
	response.addDateHeader("myToday", add_date);
	response.addIntHeader("myNumber", add_int);
	response.addIntHeader("myNumber2", 2024);
	//response.addHeader("myName", add_str);
	//response.setHeader("myName2", "신사임당");
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>내장 객체 - response</title>
</head>
<body>
	<h2>응답 헤더 정보 출력</h2>
	<%
		Collection<String> headerNames = response.getHeaderNames();
		for(String hName : headerNames) {
			String hValue = response.getHeader(hName);
	%>
			<li><%= hName %> : <%= hValue %></li>
	<%
		}
			
	%>
</body>
</html>





