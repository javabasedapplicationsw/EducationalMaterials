<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table border="1" width="90%">
  <tr>
    <td align="center">
    	<%
    		if (session.getAttribute("userId") == null) {
		%>
			<a href="../session02/loginForm.jsp">로그인</a>
		<%
    		} else {
		%>
			<a href="../session02/logout.jsp">로그아웃</a>
		<%
    		}
    	%> 
    </td> 
    <td align="center"><a href="../board/list.jsp">게시판</a></td>
    <td align="center">게시판(페이징)</td>
  </tr>
</table>

    
    
    
    
    
    
    
    