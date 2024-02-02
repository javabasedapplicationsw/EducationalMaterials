<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<title>ajax</title>
</head>
<body>
	<h2>{name:"user3", age:10}</h2>
	<button id="sendBtn" type="button">SEND</button>
	
	<h2>Data from Server : </h2>
	<div id="data"></div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			let person = {name:"user3", age:10}
			let person2 = {}
			
			$("#sendBtn").click(function() {
				$.ajax({
					type : 'post',						//요청 메서드
					url : '/orm/send/',					//요청 URI
					headers : {"content-type" : "application/json"}, 		//요청 헤더 
					dataType : 'text',					// 서버로부터 전송할 데이터.
					data : JSON.stringify(person),		// stringify()로 직렬화
					success : function(result) {		// result는 서버가 전송한 데이터
						person2 = JSON.parse(result)
						alert("received = " + result)
						$("#data").html("name = "+person2.name+ ", age = " +person2.age)
					},
					error : function() { alret("error")	}
				})
				alert("the request is sent")
			})
		})
	</script>
</body>
</html>

















