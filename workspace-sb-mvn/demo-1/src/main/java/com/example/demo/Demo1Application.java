package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication				// 스프링 부트 애플리케이션을 실행해주는 역할 (스프링 부트 탐색지점) - 자동 설정, 컴포넌트 스캔 
@RestController						// REST API를 만들기 위한 Controller 어노테이션
@RequestMapping(value = "hello")	// (value = 패스), 클라이언트에서 들어온 요청이 value의 패스와 동일하면 해당 클래스나 메서드를 실행
public class Demo1Application {

	public static void main(String[] args) {			// 메인 클래스 진입지점
		SpringApplication.run(Demo1Application.class, args);		// 스프링 부트 애플리케이션 구동지점
	}
	
	@GetMapping(value = "/{firstName}")
	public String helloGet(
			@PathVariable("firstName") String firstName,		// 클라이언트 요청 URL에 담긴 특정값을 담을 때 사용	
			@RequestParam("lastName") String lastName) {		// 요청의 파라미터 내용을 받는데 사용됨. 요청 파리미터 내용과 메서드의 파라미터와 매칭함
		return String.format("{\"메시지 \" : \"Hello  %s   %s  \"}", firstName, lastName);
	}
	
	@PostMapping
	public String helloPost(@RequestBody HelloRequest request) {// 요청의 body에 담긴 내용을 받는데 사용됨.  클라이언트에서 받은 body 내용을 메서드의 파라미터와 매칭해주는 역할 
		return String.format("{\"메시지 \" : \"Hello  %s   %s  \"}", request.getFirstName(), request.getLastName());
	}

}

class HelloRequest {
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
