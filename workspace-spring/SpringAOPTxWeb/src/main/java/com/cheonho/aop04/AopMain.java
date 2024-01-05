package com.cheonho.aop04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		ApplicationContext ac = 
				new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context_aop.xml");
		
		MyMath mm = (MyMath) ac.getBean("myMath");
		mm.add(3, 5);
		mm.add(1, 2, 3);
		mm.multiply(3, 5);
		mm.divide(4, 2);
		
		try {
			mm.divide(4, 0);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}








