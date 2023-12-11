package kr.co.hiweb;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {

	@RequestMapping(value = {"/req/loginForm.do", "/req/loginForm2.do"}, method = {RequestMethod.GET})
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/loginForm");
		return mav;
	}
	
	@RequestMapping(value = "/req/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		String requestLine = request.getMethod();
		requestLine += " " + request.getRequestURI();
		
		String queryString = request.getQueryString();
		requestLine += queryString == null ? "" : "?"+queryString;
		requestLine += " " + request.getProtocol();
		System.out.println(requestLine);
		
		// request body -- post 일 때만 해당 (get은 body가 없음)
		final int CONTENT_LENGTH = request.getContentLength();
		System.out.println("content length : " + CONTENT_LENGTH);
		
		if (CONTENT_LENGTH > 0) {
			try {
				request.setCharacterEncoding("utf-8");
				mav.setViewName("/login/result");
				
				String userId = request.getParameter("userId");
				String userName = request.getParameter("userName");
				
				mav.addObject("userId", userId);
				mav.addObject("userName", userName);
				
				System.out.println();
				System.out.println("userId = " +userId+ ", userName = " + userName);
				
			} catch (UnsupportedEncodingException e) { e.printStackTrace(); }
			
		}
		
		return mav;
	}
}



















