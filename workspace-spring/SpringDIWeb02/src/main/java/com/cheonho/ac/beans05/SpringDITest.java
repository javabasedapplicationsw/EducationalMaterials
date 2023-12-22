package com.cheonho.ac.beans05;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
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
@Component class Engine {}
@Component class Door {}

public class SpringDITest {

	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("config5.xml");
		Car car = (Car) ac.getBean("car");
		Engine engine = (Engine) ac.getBean("engine");
		Door door = (Door) ac.getBean("door");
		
		car.setColor("white");
		car.setOil(500);
		car.setEngine(engine);
		car.setDoors(new Door[] {ac.getBean("door", Door.class), ac.getBean("door", Door.class)});
		
		System.out.println("car = " + car);

	}
}











