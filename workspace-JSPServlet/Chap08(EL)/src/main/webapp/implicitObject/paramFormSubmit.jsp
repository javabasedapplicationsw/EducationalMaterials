<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>표현 언어(EL) - 폼값 처리</title>
</head>
<body>
	<h2>EL로 폼값 받기</h2>
	<ul>
		<!-- text, radio 타입의 input 태그와 select 태그는 값이 하나만 전송됨 => EL의 내장객체인 param으로 값을 받을수 있음 -->
		<li>이름 : ${param.name }</li>
		<li>성별 : ${param.gender }</li>
		<li>학력 : ${param.grade }</li>
		<li>관심 사항 : ${paramValues.interest[0] }	<!-- checkbox 타입은 다수의 값을 전송함 => paramValues를 통해 배열로 값을 받음 -->
					  ${paramValues.interest[1] } 
					  ${paramValues.interest[2] } 
					  ${paramValues.interest[3] } 
		</li>
	</ul>
</body>
</html>