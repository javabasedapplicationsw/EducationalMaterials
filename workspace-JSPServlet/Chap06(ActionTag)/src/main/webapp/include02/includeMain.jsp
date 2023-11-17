<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// page 영역과 request 영역에 속성 저장
	pageContext.setAttribute("pAttr", "천호역");
	request.setAttribute("rAttr", "강동역");
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>지시어와 액션 태그 비교</title>
</head>
<body>
	<h2>지시어와 액션 태그 비교</h2>
	<h3>지시어로 페이지 포함하기</h3>
	<%@ include file="../include/outPage.jsp" %>
	<p>외부 파일에 선언한 변수 : <%=himedia %></p>
	
	<h3>액션 태그로 페이지 포함하기</h3>
	<jsp:include page="../include/outPage2.jsp" />
	<p>외부 파일에 선언한 변수 : <%-- <%=himedia2 %> --%></p>				<!-- 선언하지 않은 변수라는 에러 발생함 -->
	
</body>
</html>





