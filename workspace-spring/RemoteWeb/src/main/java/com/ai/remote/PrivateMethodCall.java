package com.ai.remote;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) {
		Hello hello = new Hello();
		//hello.himedia();			//private 이라서 외부 호출 불가 
		
		/*
		 *    http://localhost:8080/remote/okay  실행시 himedia() 호출됨
		 *    	- refection api를 사용했기 때문에 가능함 
		 *    		- java.lang.reflect 패키지를 제공
		 *    		- 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공 
		 */
		
		try {
			/*
			 * Hello 클래스의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어옴
			 * 	- 클래스 파일(.class)이 메모리에 올라갈 때 클래스마다 Class 객체가 하나씩 생성됨
			 */
			Class helloClass = Class.forName("com.ai.remote.Hello");
			Hello hello2 = (Hello)helloClass.newInstance();		// Class객체가 가진 정보로 객체 생성
			
			Method himedia = helloClass.getDeclaredMethod("himedia");
			himedia.setAccessible(true);		// private인 himedia()를 접근가능하게 함 
			
			himedia.invoke(hello2);				// hello.himedia()와 동일함
			
			
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
















