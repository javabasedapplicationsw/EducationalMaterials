package kr.co.himedia.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.one")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();							// 현재 경로에서 호스트명을 제외한 나머지 부분
		int lastSlash = uri.lastIndexOf("/");							// 마지막 슬래시(/)의 인덱스 구함
		String commandStr = uri.substring(lastSlash);					// 인덱스로 경로의 마지막 부분의 문자열을 얻어옴
		
		if (commandStr.equals("/join.one"))								// 문자열을 통해 페이지를 구분하여, 각 페이지를 처리할수 있는 메서드 호출
			registerFunc(request);
		else if (commandStr.equals("/login.one"))
			loginFunc(request);
		else if (commandStr.equals("/board.one"))
			boardFunc(request);
		
		request.setAttribute("uri", uri);								// request 영역에 저장
		request.setAttribute("commandStr", commandStr);
		request.getRequestDispatcher("/servlet/frontController.jsp").forward(request, response);	// frontController.jsp로 포워드
	}

	// 페이지별 처리 메서드 
	private void boardFunc(HttpServletRequest request) {
		request.setAttribute("result", "<h4>게시판</h4>");
		
	}


	private void loginFunc(HttpServletRequest request) {
		request.setAttribute("result", "<h4>로그인</h4>");
		
	}


	private void registerFunc(HttpServletRequest request) {
		request.setAttribute("result", "<h4>회원가입</h4>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}








