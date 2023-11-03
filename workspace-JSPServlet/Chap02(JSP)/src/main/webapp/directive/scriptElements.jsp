<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Declaration -->    
<%!		
	public int add(int num1, int num2) {
		return num1 + num2;
	}
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>스크립트 요소</title>
</head>
<body>
	<!-- Scriptlet -->
	<%
		int result = add(10, 20);
	%>
	<!-- Experssion -->
	덧셈 결과 : <%= result %> <br/>
	덧셈 결과 : <%= add(30, 40) %>
</body>
</html>




