package com.cheonho.aop02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MyAdvice myAdvice = new MyAdvice();
		
		Class myClass = Class.forName("com.cheonho.aop02.MyClass");
		Object obj = myClass.newInstance();
		
		for(Method m : myClass.getDeclaredMethods()) {
			myAdvice.invoke(m, obj, null);
		}
	}
}

//핵심 기능(메서드)에 공통 코드를 추가해야 함
class MyClass {
	
	public void eworld1() {
		System.out.println("eworld1() is called");
		System.out.println();
	}
	
	public void eworld2() {
		System.out.println("eworld2() is called");
		System.out.println();
	}	
	
	public void iteworld() {
		System.out.println("iteworld() is called");
		System.out.println();
	}		
}

//보조 기능을 갖고 클래스
class MyAdvice {
	
	Pattern p = Pattern.compile("e.*");			// 메서드 이름이 e로 시작하는 것만 골라서 적용
	
	public boolean matches(Method m) {
		Matcher matcher = p.matcher(m.getName());	//패턴에 맞는 것만 취해서 그 핵심기능에만 보조기능이 들어가게 함.
		return matcher.matches();
	}
	
	public void invoke(Method m, Object obj, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(matches(m))
			System.out.println("[before] {");
		m.invoke(obj, args);			// eworld1(), eworld2(), iteworld() 호출가능 
		
		if(matches(m))
			System.out.println("} [after]");
	}
}











