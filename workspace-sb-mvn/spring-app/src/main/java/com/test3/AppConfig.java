package com.test3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration				// 스프링, 자바 프로젝트의 설정을 코드로 할수 있도록 함 
public class AppConfig {

	@Bean					// 해당 클래스가 스프링의 빈으로 등록된다는 것을 나타냄 
	public Employee employee() {
		return new Employee();
	}
	
	@Bean
	public Address address() {
		return new Address();
	}
}
