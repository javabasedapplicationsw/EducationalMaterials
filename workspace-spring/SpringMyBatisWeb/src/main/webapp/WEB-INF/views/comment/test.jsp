<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<title>CommentTest</title>
</head>
<body>
	<h2>CommentTest</h2>
	<button id="sendBtn" type="button">SEND</button>
	<div id="commentList"></div>
	
	<script type="text/javascript">
		let bno = 296
		
		let showList = function(bno) {
			$.ajax({
				type : 'GET',						// 요청 메서드
				url :	'/orm/comments?bno='+bno,	// 요청 URI
				success : function(result) {		// 서버로부터 응답이 도착하면 호출될 함수
					$("#commentList").html(result)	// result는 서버가 전송한 데이터(댓글들)
				},
				error : function() {				// 에러가 발생할 때 호출될 함수 
					alert("error")
				}
			})
		}
		
		$(document).ready(function() {
			$("#sendBtn").click(function() {
				showList(bno)
			})
		})
	</script>
</body>
</html>
























