package com.cheonho.di.mimic02;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car {}
class Truck extends Car {}
class SportsCar extends Car {}
class Engine {}

class AppContext {
	Map map;			//객체 저장소 
	
	public AppContext() {
		Properties p = new Properties();
		try {
			p.load(new FileReader("config2.txt"));
			
			//Properties에 저장된 내용을 Map에 저장
			map = new HashMap(p);
			
			//클래스 이름을 얻어서 객체를 생성해서 다시 map에 저장 
			for(Object key : map.keySet()) {
				Class clazz = Class.forName((String)map.get(key));
				map.put(key, clazz.newInstance());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String key) {
		return map.get(key);
	}
}

public class DIMimic02 {
	public static void main(String[] args) {
		AppContext ac = new AppContext();
		Car car = (Car) ac.getBean("car");					// 객체 찾기 - by Name (이름-id으로 찾기)
		Engine engine = (Engine) ac.getBean("engine");		// 객체 찾기 - by Name (이름-id으로 찾기)
		
		System.out.println("car = " + car);
		System.out.println("engine = " + engine);
	}
}










