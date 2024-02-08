package com.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWebApi {

	@GetMapping("/hello")
	public String hello() {
		return "Spring Boot Hello";
	}
}
