package com.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Employee {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee() { address = new Address(); }
	public Employee(Address address) {	this.address = address;	}
}

@Component
class Address {
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

public class MySpringApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Address address = context.getBean(Address.class);
		
		address.setLocation("Seoul");
		System.out.println(address.getLocation());
		
		Employee employee = context.getBean(Employee.class);
		employee.setAddress(address);
		System.out.println(employee.getAddress().getLocation());
	}

}











