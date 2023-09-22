package kr.co.himedia.this0;

public class Car /* extends Object */ {

	private String color;
	private String gearType;
	private int door;
	
	public Car() {
		//super();
		//직접적으로 인스턴스 멤버변수를 초기화 
//		this.color = "흰색";
//		this.gearType = "수동";
//		this.door = 4;
		this("검정", "자동", 5);
	}

	public Car(String color, String gearType, int door) {
		//super();
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

	@Override
	public String toString() {
		return this.color +", "+ this.gearType +", "+ this.door;
	}
	
	
	
	
	
}
