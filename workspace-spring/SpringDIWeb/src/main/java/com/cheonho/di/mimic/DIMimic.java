package com.cheonho.di.mimic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Car {}
class Truck extends Car {}
class SportsCar extends Car {}
class Engine {}

public class DIMimic {

	public static void main(String[] args) throws Exception {
		Car car = (Car)getObject("car");
		Engine engine = (Engine)getObject("engine");
		System.out.println("car = " + car);
		System.out.println("engine = " + engine);
	}
	
	public static Object getObject(String key) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Properties p = new Properties();
		p.load(new FileReader("config.txt"));			//config.txt 읽어서 Properties에 저장 
		
		//클래스 객체를 얻음
		Class clazz = Class.forName(p.getProperty(key));
		return clazz.newInstance();		//객체를 생성해서 변환
	}
}













