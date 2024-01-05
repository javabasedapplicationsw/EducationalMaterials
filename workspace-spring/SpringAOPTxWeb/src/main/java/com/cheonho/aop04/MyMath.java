package com.cheonho.aop04;

import org.springframework.stereotype.Component;

@Component
public class MyMath {
	
	public void hello() {}
	public void hello(int a) {}
	public void hello(String a, int b) {}
	
	public int add(int a, int b) {
		int result = a+b;		
		return result;
	}
	
	public int add(int a, int b, int c) {
		int result = a+b+c;
		return result;
	}
	
	public int substract(int a, int b) {
		int result = a-b;
		return result;
	}
	
	public int multiply(int a, int b) {
		int result = a*b;
		return result;
	}	
	
	public int divide(int a, int b) {
		int result = a / b;
		return result;
	}
}










