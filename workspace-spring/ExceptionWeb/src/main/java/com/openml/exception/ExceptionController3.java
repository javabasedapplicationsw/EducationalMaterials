package com.openml.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController3 {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in ExceptionController3");
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex4")
	public String openml(Exception ex, Model m) throws Exception {
			m.addAttribute("ex", ex);
			throw new Exception("예외가 발생했습니다.");					
	}	
}
