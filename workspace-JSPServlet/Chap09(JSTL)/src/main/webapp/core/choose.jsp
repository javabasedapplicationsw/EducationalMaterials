<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL - choose/when/otherwise</title>
</head>
<body>
	<!-- 변순선언 -->
	<c:set var="number" value="2025" />

	<h4>choose 태그로 홀짝 판단하기</h4>
	<c:choose>
		<c:when test="${number mod 2 eq 0 }">
			${number }는 짝수입니다.
		</c:when>
		<c:otherwise>
			${number }는 홀수입니다.
		</c:otherwise>
	</c:choose>
	
	<h4>국,영,수 점수를 입력하면 평균을 내어 학점 출력하기</h4>
	<form action="">					<!-- url 입력하지 않으면 폼값은 현재 페이지로 쿼리스트링 통해 전송됨  -->
		국어 : <input type="text" name="kor" /><br/>
		영어 : <input type="text" name="eng" /><br/>
		수학 : <input type="text" name="math" /><br/>
		<input type="submit" value="학점 구하기" />
	</form>
	
	<!-- 과목 점수 입력여부 확인 -->
	<c:if test="${not (empty param.kor or empty param.eng or empty param.math) }">
		<!-- 평균계산 -->
		<c:set var="avg" value="${(param.kor + param.eng + param.math) /3 }" />
		평균 점수는 ${avg } 이고, 
		
		<!-- 학점출력 -->
		<c:choose>
			<c:when test="${avg >= 90 }">A 학점</c:when>
			<c:when test="${avg >= 80 }">B 학점</c:when>
			<c:when test="${avg >= 70 }">C 학점</c:when>
			<c:when test="${avg >= 60 }">D 학점</c:when>
			<c:otherwise>F 학점</c:otherwise>
		</c:choose>
		입니다.
	</c:if>
</body>
</html>

















