package kr.co.hisep;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//년월일을 입력하면 해당 요일을 알려주는 프로그램
@Controller					//1. 원격 호출가능한 프로그램으로 등록
public class DayOfTheWeekMVC {

	@RequestMapping("/getDayMVC")		//2. URL과 메서드를 연결
	private String himedia(int year, int month, int day, Model model) throws UnsupportedEncodingException {
		
		//1. 유효성 검사
		if (!isValid(year, month, day))
			return "dayofweekerror";			
		
		char dayofTheWeek = getDayOfWeek(year, month, day);
		
		//3. Model에 작업 결과 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("dayofTheWeek", dayofTheWeek);
		
		return "dayofweek";

	}

	// 2. 요일 산정
	private char getDayOfWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);			//날짜 설정
		
		int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);			// 요일 리턴 (sunday = 1, ...)
		
		char dayofTheWeek = " 일월화수목금토".charAt(dayofWeek);	// " 일월화수목금토".charAt(1) => 일 
		return dayofTheWeek;
	}

	private boolean isValid(int year, int month, int day) {
		if (year == -1 || month == -1 || day == -1)
			return false;
		return (1<= month && month <=12) && (1<= day && day <= 31);			//간단한 체크 
	}
}






















