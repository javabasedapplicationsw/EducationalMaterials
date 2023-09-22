package kr.co.himedia.constructor05;

public class PersonTest {

	public static void main(String[] args) {
		
		Person personLee = new Person();
		personLee.showInfo();
		System.out.println();
		
		personLee.height = 185;
		personLee.weight = 85;
		personLee.gender = "남성";
		personLee.name = "이순신";
		personLee.age = 40;
		personLee.showInfo();
	}
}





