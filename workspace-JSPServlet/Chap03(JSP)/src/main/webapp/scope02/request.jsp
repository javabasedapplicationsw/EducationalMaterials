<%@page import="kr.co.himedia.common.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("requestString", "request 영역에 문자열 저장");
	request.setAttribute("requestPersonDTO", new PersonDTO("신사임당", 40));
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>request 영역</title>
</head>
<body>
	<h2>request 영역의 속성값 삭제</h2>
	<%
		request.removeAttribute("requestString");
		request.removeAttribute("requestInt");				//미저장된 것 삭제하기 -- 에러 없음
	%>
	<h2>request 영역의 속성값 읽기</h2>
	<%
		PersonDTO rPersonDTO = (PersonDTO)request.getAttribute("requestPersonDTO");
	%>
	<ul>
		<li>String 객체 : <%= request.getAttribute("requestString") %></li>
		<li>PersonDTO 객체 : <%= rPersonDTO.getName() %>, <%= rPersonDTO.getAge() %></li>
	</ul>
	
	<h2>포워드된 페이지에서 request 영역 속성값 읽기</h2>
	<%
		request.getRequestDispatcher("requestForward.jsp?param1=하이미디어&param2=himedia").forward(request, response);
	%>
</body>
</html>

































