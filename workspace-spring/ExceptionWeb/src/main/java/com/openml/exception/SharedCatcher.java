package com.openml.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SharedCatcher {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in SharedCatcher");
		m.addAttribute("ex", ex);
		return "error";
	}
}
