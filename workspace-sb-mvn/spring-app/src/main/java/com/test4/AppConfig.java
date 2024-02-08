package com.test4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration				// 스프링, 자바 프로젝트의 설정을 코드로 할수 있도록 함 
@ComponentScan(basePackages = "com.test4")
public class AppConfig {


}
