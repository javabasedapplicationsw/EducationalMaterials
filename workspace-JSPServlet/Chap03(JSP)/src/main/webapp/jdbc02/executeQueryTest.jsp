<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.co.himedia.common.JDBConnectionTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>executeQuery - jdbc</title>
</head>
<body>
	<h2>회원 목록 조회 (executeQuery() 사용)</h2>
	<%
		//DB에 연결
		JDBConnectionTest jdbc = new JDBConnectionTest();
	
		//쿼리문 생성
		String sql = "SELECT ID, PASS, NAME, REGIDATE FROM MEMBER";
		Statement stmt = jdbc.con.createStatement();
		
		//쿼리 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		//결과 확인 (웹 페이지 출력)
		while(rs.next()) {			// 다음 행(레코드)을 반환함
			String id = rs.getString(1);
			String pw = rs.getString(2);
			String name = rs.getString(3);
			Date regidate = rs.getDate(4);
			
			out.println(String.format("%s %s %s %s", id, pw, name, regidate) + "<br/>");
		}
		
		//연결 닫기
		jdbc.close();
	%>
</body>
</html>













