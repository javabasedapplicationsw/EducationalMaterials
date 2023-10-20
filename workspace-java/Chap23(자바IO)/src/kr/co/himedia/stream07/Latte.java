package kr.co.himedia.stream07;

public class Latte extends Decorator {

	public Latte(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public void brewing() {
		super.brewing();
		System.out.print("우유 추가 ");
	}
}
