<%@page import="java.util.HashMap"%>
<%@page import="kr.co.himedia.common.PersonDTO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>application 영역</title>
</head>
<body>
	<h2>application 영역 공유</h2>
	<%
		Map<String, PersonDTO> maps = new HashMap<>();
		maps.put("actor1", new PersonDTO("레오나르도 디카프리오", 49));
		maps.put("actor2", new PersonDTO("릴리 글래드스톤", 38));
		application.setAttribute("maps", maps);
	%>
	application 영역에 속성이 저장되었습니다
</body>
</html>