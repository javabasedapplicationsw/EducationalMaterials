package com.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Employee {
	Address address;
	public Employee() { address = new Address(); }
	public Employee(Address address) {	this.address = address;	}
}

class Address {}

public class MySpringApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	}

}
