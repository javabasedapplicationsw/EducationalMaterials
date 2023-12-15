package com.openml.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex3")
	public String openml(Exception ex, Model m) throws Exception {
			m.addAttribute("ex", ex);
			throw new Exception("예외가 발생했습니다.");					
	}
}
