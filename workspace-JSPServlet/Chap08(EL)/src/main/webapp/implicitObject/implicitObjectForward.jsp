<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>표현 언어(EL) - 내장 객체</title>
</head>
<body>
	<H2>각 영역에 저장된 속성을 읽기</H2>
	<ul>
		<!-- 내장 객체의 영역중 page 영역은 포워드되면 소멸됨 -->
		<li>페이지 영역2(속성) : ${pageScope.scopeValue }</li>
		<li>리퀘스트 영역2(속성) : ${requestScope.scopeValue }</li>
		<li>세션 영역2(속성) : ${sessionScope.scopeValue }</li>
		<li>애플리케이션 영역2(속성) : ${applicationScope.scopeValue }</li>
	</ul>
	
	<h3>영역 지정없이 속성 읽기</h3>
	<ul>
		<!-- 영역 따로 지정하지 않으면 가장 좁은 영역에서부터 속성을 찾음 => page영역에 scopeValue라는 속성이 없음, 
		     그 다음으로 범위가 좁은 request 영역에서 속성을 읽어옴-->
		<li>${scopeValue }</li>
	</ul>
</body>
</html>

























