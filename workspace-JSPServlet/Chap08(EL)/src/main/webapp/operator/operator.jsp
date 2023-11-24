<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num1 = 3;
	pageContext.setAttribute("num2", 4);
	pageContext.setAttribute("num3", "5");
	pageContext.setAttribute("num4", "8");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title> EL - 연산자</title>
</head>
<body>
	<h3>변수 선언 및 할당</h3>
	스크립틀릿에서 선언한 변수 : ${num1 } <br/>	<!-- EL은 스클립틀릿에서 선언한 변수를 즉시 사용할수 없음 -->
	page 영역에 저장된 변수 : ${num2 } <br/>		<!-- page 영역에 저장된 속성은 정상적으로 출력됨 -->
	변수 할당 및 즉시 출력 : ${num1 = 7 } <br/>
	변수 할당 및 별도 출력 : ${num2 = 8;'' } => ${num2 } <br/>
	num1 = ${num1 }, num2 = ${num2 }, num3 = ${num3 }, num4 = ${num4 }
	
	<h3>산술연산자</h3>
	num1 + num2 : ${num1 + num2 }<br/>
	num1 - num2 : ${num1 - num2 }<br/>
	num1 * num2 : ${num1 * num2 }<br/>
	num3 / num4 : ${num3 / num4 }<br/>
	num3 div num4 : ${num3 div num4 }<br/>
	num3 % num4 : ${num3 % num4 }<br/>
	num3 mod num4 : ${num3 mod num4 }<br/>
	
	<h3>+ 연산자는 덧셈만 가능</h3>
	num1 + "34" : ${num1 + "34" }<br/>
	<%-- num2 + "이십" : ${num2 + "이십" }<br/> --%>	<!-- 숫자 형태의 문자열이라면 자동으로 숫자로 변환되어 계산됨, 문자가 포함되어 있다면 변환 안됨  -->
	<%-- "삼십" + "사십" : ${"삼십" + "사십" } --%>
	
	
	<h3>비교연산자</h3>
	num4 > num3 : ${num4 > num3 }<br/>
	num4 gt num3 : ${num4 gt num3 }<br/>
	
	num1 < num3 : ${num1 < num3 }<br/>
	num1 lt num3 : ${num1 lt num3 }<br/>
		
	num2 >= num4 : ${num2 >= num4 }<br/>
	num2 ge num4 : ${num2 ge num4 }<br/>
	
	num1 == num4 : ${num1 == num4 }<br/>
	num1 eq num4 : ${num1 eq num4 }<br/>
</body>
</html>














