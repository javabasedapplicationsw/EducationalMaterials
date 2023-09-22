package kr.co.himedia.this0;

public class Person {
	
	String name;
	int age;
	
	public Person() {
		this("no name", 10);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person getPerson() {
		return this;
	}
	
	public void showInfo() {
		System.out.println("name : " +name+ ", age : " + age);
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		person.showInfo();
		
		Person person2 = person.getPerson();
		System.out.println(person);
		System.out.println(person2);
		
		Person person3 = new Person("이순신", 30);
		person3.showInfo();
		System.out.println(person3);
	}

}







