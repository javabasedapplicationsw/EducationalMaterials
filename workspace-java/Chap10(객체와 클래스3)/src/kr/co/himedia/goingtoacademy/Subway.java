package kr.co.himedia.goingtoacademy;

public class Subway {
	
	private int lineNumber;
	private int passengerCount;
	private int money;
	
	public Subway(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public void ride(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void showInfo() {
		System.out.println(lineNumber +"호선 지하철의 승객은 "+ passengerCount + "명이고, 수입은 " +money+ "원입니다.");
	}
}






