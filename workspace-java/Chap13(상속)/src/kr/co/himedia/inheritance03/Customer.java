package kr.co.himedia.inheritance03;

public class Customer /* extends Object */ {

	protected int customerId;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
	// default Constructor 없애고 매개 변수가 있는 생성자 추가
//	public Customer() {
//		this.customerGrade = "SILVER";
//		bonusRatio = 0.01;
//		
//		System.out.println("Customer() 생성자 호출");
//	}
	
	public Customer(int customerId, String customerName) {
		//super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGrade = "SILVER";
		bonusRatio = 0.01;
		
		System.out.println("Customer(int customerId, String customerName) 생성자 호출");		
		
	}	
	
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}
	


	public String showInfo() {
		return customerName +"님의 등급은 "+customerGrade+
							"이며, 보너스 포인트는 " +bonusPoint+ "입니다.";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	
	
	
}














