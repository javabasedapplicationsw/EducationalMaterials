<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String popupMode = "on";			// 레이어 팝업창 띄울지 여부 
	
	Cookie[] cookies = request.getCookies();		// 쿠키를 읽어 popupMode 값 설정
	if (cookies != null) {
		for (Cookie c : cookies) {
			String cookieName = c.getName();
			String cookieValue = c.getValue();
			if (cookieName.equals("PopupClose")) {		// PopupClose 쿠기가 존재하면
				popupMode = cookieValue;				// popupMode의 값 업데이트
			}
		}
	}
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
  			
  			             /* id가 noToday이면서 체크된 체크박스  */    /* 값을 읽어와서 */
  			let chkVal = $("input:checkbox[id=noToday]:checked").val();		/* 체크하면 chkVal에 "1"이 저장됨. */
  			
  			$.ajax({									/* jQuery의 ajax() 함수로 비동기 요청 */
  				url : 'popupCookie.jsp',				/* popupCookie.jsp 파일에 */
  				type : 'get',							/* HTTP GET 방식으로 */
  				data : {noToday : chkVal},				/* noToday=<chkVal 변수의 값> 데이터를 */
  				dataType : "text",						/* 응답 데이터의 타입은 일반 텍스트이며  */
  				success : function(resData) {			/* 요청 성공 시 */
					if (resData != '')					/* 응답 데이터가 있다면 */
						location.reload();				/* 페이지를 새로 고침 */
				}  								
  			});
  			
  		});		
	})
  
  </script>
</head>
<body>
	<h2>팝업 메인 페이지 </h2>
	
	<%
		for (int i = 1; i <= 10; i++) {
			out.print("현재 팝업창은 " +popupMode+ " 상태입니다. <br/> ");
		}
		
		if (popupMode.equals("on")) {			
		%>
		<div id="popup">	<!-- 공지사항 팝업 화면 -->
			<h2 align="center">공지사항 팝업입니다.</h2>
			<div align="right">
				<form action="" name="popFrm">
					<input type="checkbox" id="noToday" value="1" />오늘은 그만 보기
					<input type="button" id="closeBtn" value="닫기" />
				</form>
			</div>
		</div>				
		<%			
		}
	%>
	

</body>
</html>
















