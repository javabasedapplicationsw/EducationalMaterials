package kr.co.himedia.userdefinetype05;

/*
 * 한 사람의 데이터를 저장할 변수를 선언함
 * 객체를 메모리에 생성함
 */
public class PersonTest {

	public static void main(String[] args) {
		
		Person p = new Person();				// 객체가 생성된 후
		p.name = "이순신";						// 멤버에 접근 - .(dot 점) 연산자로 접근함 
		p.age = 40;
		p.phone = "010-1232-1122";
		System.out.println(p.name +" "+ p.age +" "+ p.phone);
		
		p.play();
		p.eat();
		p.walk();
		
		System.out.println();
		
		Person p1 = new Person();
		p1.name = "신사임당";
		p1.age = 30;
		p1.phone = "010-1456-1122";
		System.out.println(p1.name +" "+ p1.age +" "+ p1.phone);
		
		p1.play();
		p1.eat();
		p1.walk();		
	}
}
