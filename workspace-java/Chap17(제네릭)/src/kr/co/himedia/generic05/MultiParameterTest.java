package kr.co.himedia.generic05;

class Camp<T1, T2> {
	private T1 param1;
	private T2 param2;
	
	public void set(T1 o1, T2 o2) {
		this.param1 = o1;
		this.param2 = o2;
	}
	
	public String toString() {
		return param1 +" & "+ param2;
	}
}

public class MultiParameterTest {
	public static void main(String[] args) {
		Camp<String, Integer> camp = new Camp<>();
		camp.set("Apple iPhone", 15);
		System.out.println(camp);
	}
}
