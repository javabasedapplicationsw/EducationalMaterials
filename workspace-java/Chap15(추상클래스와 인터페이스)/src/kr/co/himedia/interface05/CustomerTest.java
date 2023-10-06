package kr.co.himedia.interface05;

public class CustomerTest {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.buy();
		customer.sell();
		customer.sayWorld();
		
		Buy buyer = customer;				//upcasting
		buyer.buy();
		
		Sell seller = customer;				//upcasting
		seller.sell();
		
		buyer.order();
		seller.order();
	}
}
