package kr.co.himedia.singleton02;

public class CarFactoryTest {

	public static void main(String[] args) {
		
		CarFactory carFactory = CarFactory.getInstance();
		Car bMWiX1 = carFactory.createCar();
		Car bMWiXM60 = carFactory.createCar();
		Car bMWiXM61 = carFactory.createCar();
		
		System.out.println(bMWiX1.getCarNum());
		System.out.println(bMWiXM60.getCarNum());
		System.out.println(bMWiXM61.getCarNum());
	}
}
