package kr.co.himedia.abstractclass02;

public class CarTest {
	
	public static void main(String[] args) {
		
		Car aiCar = new AICar();
		aiCar.run();
		
		System.out.println();
		
		Car scCar = new SelfControlCar();
		scCar.run();
	}

}
