<%@page import="kr.co.himedia.jstl.PersonDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>		<!-- JSTL 사용시 태그 앞에 붙일 접두어,  태그 라이브러리 URI 식별자 -->
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL - set</title>
</head>
<body>
	<!-- 변수 선언 -->
	<c:set var="direct"  value="100" />
	<c:set var="el" value="${ direct mod 5 }" />
	<c:set var="date" value="<%= new Date() %>" />
	<c:set var="between">
		11월 22일 수요일
	</c:set>
	
	<h4>EL을 이용해 변수 출력</h4>
	<ul>
		<li>direct : ${pageScope.direct }</li>
		<li>el : ${el }</li>
		<li>date : ${date }</li>
		<li>between : ${between }</li>
	</ul>
	
	<!-- 자바빈즈 생성 시 생성자를 통해 초깃값 설정함, request 영역에 변수를 저장-->
	<h4>자바빈즈 생성 - 생성자 사용</h4>
	<c:set var="personVar" value='<%= new PersonDTO("이순신", 43) %>' scope="request" />
	<ul>
		<li>이름 : ${requestScope.personVar.name }</li>
		<li>나이 : ${personVar.age }</li>
	</ul>
	
	<!-- 자바빈즈를 생성 후 값을 나중에 설정하려면 target, property 속성을 사용함. target에는 변수명 지정하고, property에는 멤버 변수명을 지정함  -->
	<h4>자바빈즈 생성2 -  target, property 사용</h4>
	<c:set var="personVar2" value="<%= new PersonDTO() %>" scope="request" />
	<c:set target="${personVar2 }" property="name" value="신사임당"  />
	<c:set target="${personVar2 }" property="age" value="46" />
	<ul>
		<li>이름 : ${personVar2.name }</li>
		<li>나이 : ${requestScope.personVar2.age } </li>
	</ul>
</body>
</html>



















