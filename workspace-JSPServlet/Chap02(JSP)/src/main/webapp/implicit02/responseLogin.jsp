<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>내장 객체 - response</title>
</head>
<body>
	<%
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pwd");
		if(id.equalsIgnoreCase("himedia") && pwd.equalsIgnoreCase("0305")) {
			response.sendRedirect("responseWelcome.jsp");
		}
		else {
			request.getRequestDispatcher("responseObject.jsp?loginErr=1").forward(request, response);
		}
	%>
</body>
</html>