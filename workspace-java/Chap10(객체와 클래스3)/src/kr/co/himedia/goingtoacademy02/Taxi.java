package kr.co.himedia.goingtoacademy02;

public class Taxi {
	
	private String companyName;
	private int money;
	
	public Taxi(String companyName) {
		this.companyName = companyName;
	}
	
	public void take(int money) {
		this.money += money;
	}
	
	public void showTaxiInfo() {
		System.out.println(companyName +" 택시 수입은 "+ money +"원 입니다.");
	}

}
