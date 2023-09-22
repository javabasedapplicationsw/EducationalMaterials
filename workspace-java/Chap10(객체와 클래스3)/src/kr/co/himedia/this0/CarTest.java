package kr.co.himedia.this0;

public class CarTest {

	public static void main(String[] args) {
		Car car = new Car();			//기본형 차주문
		System.out.println(car);
		
		Car car2 = new Car("회색", "오토", 2);
		System.out.println(car2);
	}
}
