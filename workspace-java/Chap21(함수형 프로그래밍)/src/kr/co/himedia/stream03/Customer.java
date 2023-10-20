package kr.co.himedia.stream03;
/*
 * 여행사 패키지 여행 상품이 있습니다.
 * 여행 비용은 15세 이상은 100만원, 그 미만은 50만원입니다.
 * 고객 세명이 패키지 여행을 떠납니다.
 * 비용 계산과 고객 검색에 대한 연산을 스트림을 활용하여 구현하시오.
 */
public class Customer {

	private String name;
	private int age;
	private int price;
	
	public Customer() {}

	public Customer(String name, int age, int price) {
		//super();
		this.name = name;
		this.age = age;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", price=" + price + "]";
	}
	
	
	
}
