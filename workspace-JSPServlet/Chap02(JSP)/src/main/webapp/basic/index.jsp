<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>								<!-- 지시어(Directive) -->
<%!
	String str1 = "JSP";
	String str2 = "즐거운 목요일입니다.";
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>HelloJSP</title>
</head>
<body>
	<h2>안녕하세요 <%= str1 %></h2>
	<p>
		<%
			out.println(str2 + str1 + "입니다. 하드스터디해요^^");
		%>
	</p>
</body>
</html>