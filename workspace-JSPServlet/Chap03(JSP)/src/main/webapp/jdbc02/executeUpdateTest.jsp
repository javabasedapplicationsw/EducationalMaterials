<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.himedia.common.JDBConnectionTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>executeUpdate - jdbc</title>
</head>
<body>
	<h2>회원 추가 (executeUpdate() 사용)</h2>
	<%
		//DB에 연결
		JDBConnectionTest jdbc = new JDBConnectionTest();
	
		//입력 값
		String id = "hm";
		String pass = "0305";
		String name = "이순신";
		
		//쿼리문 생성
		//입력값에 사용된 물음표 => 인파라미터 (나중에 정확한 값을 채워주겠다는 의미)
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, sysdate)";
		
		PreparedStatement psmt = jdbc.con.prepareStatement(sql);
		psmt.setString(1, id);		// 첫번째 매개변수가 인파라미터의 순서임
		psmt.setString(2, pass);	// 첫번째 인파라미터가 1번임, 차례로 1씩 증가함 
		psmt.setString(3, name);
		
		//쿼리문 실행
		int result = psmt.executeUpdate();		//성공적으로 입력된 레코드의 수가 정수형으로 반환됨
		out.println(result + "행이 입력되었습니다.");
		
		//연결 닫기
		jdbc.close();
		
	%>
</body>
</html>













