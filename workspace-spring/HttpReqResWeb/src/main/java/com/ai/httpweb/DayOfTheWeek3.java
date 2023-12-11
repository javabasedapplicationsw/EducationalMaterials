package com.ai.httpweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//년월일을 입력하면 해당 요일을 알려주는 프로그램
@Controller					//1. 원격 호출가능한 프로그램으로 등록
public class DayOfTheWeek3 {

	@RequestMapping("/getDayOfTheWeek3")		//2. URL과 메서드를 연결
	private void himedia(HttpServletRequest request) throws UnsupportedEncodingException {
		
		//1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. 문자를 숫자로 변경
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);			//날짜 설정
		
		int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);			// 요일 리턴 (sunday = 1, ...)
		
		char dayofTheWeek = " 일월화수목금토".charAt(dayofWeek);	// " 일월화수목금토".charAt(1) => 일 
		
		//3. 출력
		System.out.println(year +"년 "+ month +"월 "+ day + "일은 ");
		System.out.println(dayofTheWeek +"요일입니다.");
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println("request.getCharacterEncoding(): " + request.getCharacterEncoding());
		System.out.println("request.getMethod() : " + request.getMethod());
		System.out.println("request.getProtocol() : " + request.getProtocol());
		System.out.println("request.getServerName() : " + request.getServerName());
		System.out.println("request.getRequestURL() : " + request.getRequestURL());
		System.out.println("request.getRequestURI() : " + request.getRequestURI());
		System.out.println("request.getContextPath() : " + request.getContextPath());
		System.out.println("request.getServletPath() : " + request.getServletPath());
		System.out.println("request.getQueryString() : " + request.getQueryString());
	}
}






















