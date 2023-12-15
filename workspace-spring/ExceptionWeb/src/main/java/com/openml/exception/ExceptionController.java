package com.openml.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@RequestMapping("/ex")
	public String openml(Exception ex, Model m) throws Exception {
		try {
			m.addAttribute("ex", ex);
			throw new Exception("예외가 발생했습니다.");			
			
		} catch (Exception e) {
			//e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping("/ex2")
	public String openml2(Model m) throws Exception {
		throw new NullPointerException("널 포인터 예외가 발생했습니다.");
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
}





























