package kr.co.himedia.constructor03;

public class StudentTest {

	public static void main(String[] args) {
		//기본 생성자 호출
		Student student = new Student();
		System.out.println(student.getName());
		System.out.println(student.getAge());
		
		System.out.println();
		
		//매개변수가 String, int 타입이 있는 생성자 호출
		Student student4 = new Student("이성계", 50);
		System.out.println(student4.toString());
		
		System.out.println();
		//매개변수가 String만 있는 생성자 호출
		Student student2 = new Student("신사임당");
		System.out.println(student2.toString());
		
		System.out.println();
		//매개변수가 int만 있는 생성자 호출 
		Student student3 = new Student(30);
		System.out.println(student3.toString());
	}
}











