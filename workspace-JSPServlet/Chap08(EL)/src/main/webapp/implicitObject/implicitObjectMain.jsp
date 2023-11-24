<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* scopeValue라는 같은 이름으로 속성을 저장 */
	pageContext.setAttribute("scopeValue", "페이지 영역");
	request.setAttribute("scopeValue", "리퀘스트 영역");
	session.setAttribute("scopeValue", "세션 영역");
	application.setAttribute("scopeValue", "애플리케이션 영역");
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>표현 언어(EL) - 내장 객체</title>
</head>
<body>
	<H2>각 영역에 저장된 속성을 읽기</H2>
	<ul>
		<!-- EL의 내장 객체를 통해 각 영역에 저장된 속성값 출력 -->
		<li>페이지 영역(속성) : ${pageScope.scopeValue }</li>
		<li>리퀘스트 영역(속성) : ${requestScope.scopeValue }</li>
		<li>세션 영역(속성) : ${sessionScope.scopeValue }</li>
		<li>애플리케이션 영역(속성) : ${applicationScope.scopeValue }</li>
	</ul>
	
	<h3>영역 지정없이 속성 읽기</h3>
	<ul>
		<!-- 영역 따로 지정하지 않으면 가장 좁은 영역에서부터 속성을 찾음 => page영역에 저장된 값을 가져옴-->
		<li>${scopeValue }</li>
		
		<%-- <jsp:forward page="implicitObjectForward.jsp" /> --%>
	</ul>
</body>
</html>

























