package kr.co.himedia.interface05;

public class Customer implements Buy, Sell {

	@Override
	public void sell() {
		System.out.println("Customer sell()");
		
	}

	@Override
	public void buy() {
		System.out.println("Customer buy()");
		
	}
	
	public void sayWorld() {
		System.out.println("Hello World!");
	}

	@Override
	public void order() {
		System.out.println("customer order()");
	}

}
