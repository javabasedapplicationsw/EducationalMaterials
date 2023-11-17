<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String popupMode = "on";			// 레이어 팝업창 띄울지 여부 
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>쿠키 활용한 팝업 관리</title>
  
  <style type="text/css">
  	div#popup {
  		position: absolute;
  		top: 100px;
  		left: 50px;
  		color: yellow;
  		width: 270px;
  		height: 100px;
  		background-color: gray;
  	}
  	div#popup>div {
  		position: relative;
  		background-color: #ffffff;
  		top: 0px;
  		border: 1px solid gray;
  		padding: 10px;
  		color: black;
  	}
  	
  </style>
  
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script type="text/javascript">
  	$(function() {
  	  	$('#closeBtn').click(function() {	/* 닫기 버튼을 누르면 */
  			$('#popup').hide();				/* 팝업창 숨김 처리 */
  		});		
	})
  
  </script>
</head>
<body>
	<h2>팝업 메인 페이지 </h2>
	
	<div id="popup">	<!-- 공지사항 팝업 화면 -->
		<h2 align="center">공지사항 팝업입니다.</h2>
		<div align="right">
			<form action="" name="popFrm">
				<input type="checkbox" id="noToday" value="1" />오늘은 그만 보기
				<input type="button" id="closeBtn" value="닫기" />
			</form>
		</div>
	</div>
</body>
</html>
















