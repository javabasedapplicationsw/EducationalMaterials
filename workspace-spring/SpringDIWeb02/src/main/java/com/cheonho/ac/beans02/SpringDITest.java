package com.cheonho.ac.beans02;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Car {
	private String color;
	private int oil;
	private Engine engine;
	private Door[] doors;
	
	public Car() {}		//꼭 기본 생성자를 만들어줘야 함 

	public Car(String color, int oil, Engine engine, Door[] doors) {
		//super();
		this.color = color;
		this.oil = oil;
		this.engine = engine;
		this.doors = doors;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setDoors(Door[] doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}
	
	
	
	
}
class Engine {}
class Door {}

public class SpringDITest {

	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("config2.xml");
		Car car = (Car) ac.getBean("car");
		Engine engine = (Engine) ac.getBean("engine");
		Door door = (Door) ac.getBean("door");
		
		car.setColor("red");
		car.setOil(100);
		car.setEngine(engine);
		car.setDoors(new Door[] {ac.getBean("door", Door.class), (Door)ac.getBean("door")});
		
		System.out.println("car = " + car);
	}
}











