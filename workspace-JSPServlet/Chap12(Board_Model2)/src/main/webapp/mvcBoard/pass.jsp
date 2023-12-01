<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Model2 게시판 - 비밀번호 체크</title>
  <script type="text/javascript">
  	function validateForm(form) {
		if (form.pass.value == "") {
			alert("비밀번호를 입력하세요.");
			form.pass.focus();
			return false;
		}
	}
  </script>
</head>
<body>
	<h2>Model2 게시판 - 비밀번호 체크</h2>
	<form action="../mvcboard/pass.do" method="post" name="passFrm" onsubmit="return validateForm(this);">
		<input type="hidden" name="id" value="${param.id }" />
		<input type="hidden" name="mode" value="${param.mode }" />
		<table border="1" width="90%">
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" style="width: 100px;" /></td>
			</tr>	
			<tr>
				<td colspan="2" align="center">
					<button type="submit">검증하기</button>
					<button type="reset">초기화</button>
					<button type="button" onclick="location.href='../mvcboard/list.do' ">목록</button>
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>







