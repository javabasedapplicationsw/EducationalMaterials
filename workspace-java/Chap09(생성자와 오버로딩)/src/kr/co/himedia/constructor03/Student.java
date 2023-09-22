package kr.co.himedia.constructor03;

public class Student {

	private String name;
	private int age;
	
	//기본생성자
	public Student() { 
		System.out.println("기본 생성자 호출"); 
	}
	
	//매개변수가 String만 있는 생성자
	public Student(String name) {
		this.name = name;
	}
	
	//매개변수가 int만 있는 생성자
	public Student(int age) {
		this.age = age;
	}
	
	//매개변수가 String, int 타입이 있는 생성자
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return this.getName() +", "+ this.getAge();
	}
	
	
	
}








