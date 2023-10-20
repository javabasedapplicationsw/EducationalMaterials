package kr.co.himedia.stream07;

public class Mocha extends Decorator {

	public Mocha(Coffee coffee) {
		super(coffee);
	}
	
	public void brewing() {
		super.brewing();
		System.out.print("모카 시럽 추가 ");
	};
}
