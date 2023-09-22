package kr.co.himedia.goingtoacademy;

public class Bus {

	private int busNumber;
	private int passengerCount;
	private int money;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
	//승차하다
	public void ride(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void showInfo() {
		System.out.println(busNumber +"번의 버스의 승객은 "+ passengerCount +"명이고, 수입은 " + money + "원입니다.");
	}
}








