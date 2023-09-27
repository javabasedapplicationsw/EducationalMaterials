package kr.co.himedia.inheritance02;

public class CustomerTest {
	
	public static void main(String[] args) {
		
		Customer customerL = new Customer();
		customerL.setCustomerName("이순신");
		customerL.setCustomerId(20230926);
		customerL.bonusPoint = 1000;
		System.out.println(customerL.showInfo());
		System.out.println();
		
		VIPCustomer customerS = new VIPCustomer();
		customerS.setCustomerName("신사임당");
		customerS.setCustomerId(20231026);
		customerS.bonusPoint = 10000;
		System.out.println(customerS.showInfo());
	}

}
