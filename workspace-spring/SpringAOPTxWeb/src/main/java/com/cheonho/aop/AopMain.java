package com.cheonho.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AopMain {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MyAdvice myAdvice = new MyAdvice();
		
		Class myClass = Class.forName("com.cheonho.aop.MyClass");
		Object obj = myClass.newInstance();
		
		for(Method m : myClass.getDeclaredMethods()) {
			myAdvice.invoke(m, obj, null);
		}
	}
}

//핵심 기능(메서드)에 공통 코드를 추가해야 함
class MyClass {
	
	public void eworld1() {
		//System.out.println("[before] {");
		System.out.println("eworld1() is called");
	}
	
	public void eworld2() {
		//System.out.println("[before] {");
		System.out.println("eworld2() is called");
	}	
	
	public void iteworld() {
		//System.out.println("[before] {");
		System.out.println("iteworld() is called");
	}		
}

//보조 기능을 갖고 클래스
class MyAdvice {
	
	public void invoke(Method m, Object obj, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("[before] {");
		m.invoke(obj, args);			// eworld1(), eworld2(), iteworld() 호출가능 
		System.out.println("} [after]");
	}
}











