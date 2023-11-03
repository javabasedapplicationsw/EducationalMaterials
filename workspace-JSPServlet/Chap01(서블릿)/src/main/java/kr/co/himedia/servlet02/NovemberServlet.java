package kr.co.himedia.servlet02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/november"})			// 서블릿에 연결할 URL을 작성함 -- 애노테이션을 서블릿 클래스에 선언한 것
public class NovemberServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 서블릿 컨테이너로부터 request와 response 객체를 받아 서블릿 프로그램을 수행하는 service() 메서드를 재정의 함
		 * HttpServlet에는 다양한 수행 메서드가 제공함 
			 * service​(HttpServletRequest req, HttpServletResponse resp)
			 * doGet​(HttpServletRequest req, HttpServletResponse resp)
			 * doPost​(HttpServletRequest req, HttpServletResponse resp)
			 * ...
			 * 
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		/*
		 * 웹 브라우저의 요청(GET /november?name=이순신)을 분석하면 name 변수에는 이순신이라는 문자값이 들어감 
		 */
		String requestName = request.getParameter("name");		// request 객체를 통해 웹 브라우저가 전송한 데이터를 다룰수 있음 
		String servletName = getServletConfig().getServletName();
		
		StringBuilder html = new StringBuilder();
		html.append("<html>");
		html.append("  <head>");
		html.append("    <title> 간단한 서블릿 개발하기 </title>");
		html.append("  </head>");
		html.append("  <body>");
		html.append("    <h1> "+requestName+"님 새달이 시작되었습니다. </h1>");
		html.append("    <h1> 저는 "+servletName+" 입니다. </h1>");
		html.append("    <h2> 오늘은 수요일입니다. </h2>");
		html.append("  </body>");
		html.append("</html>");
		
		//response 객체를 통해 HTTP 상태코드(200, 정상)와 HTTP 헤더를 설정
		response.setStatus(200);
		//브라우저 응답시 인코딩 방식(utf-8)을 알려주기
		response.setContentType("text/html; charset=utf-8");
		
		/*
		 * response 객체를 통해 응답을 출력함
		 * 여기서는 텍스트 데이터(HTML)를 출력하기 위해 PrintWriter를 사용함
		 * 바이너리 데이터(이미지 등)를 출력해야한다면 ServletOutputStream를 사용함 
		 */
		PrintWriter writer = response.getWriter();
		writer.write(html.toString());
	}

	
	
}













