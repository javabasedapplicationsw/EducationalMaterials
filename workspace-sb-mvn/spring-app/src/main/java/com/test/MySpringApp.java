package com.test;

class Employee {
	Address address;
	public Employee() { address = new Address(); }
	public Employee(Address address) {	this.address = address;	}
}

class Address {}

public class MySpringApp {
	
	public static void main(String[] args) {
		Address address = new Address();
		Employee employee = new Employee(address);
	}

}
