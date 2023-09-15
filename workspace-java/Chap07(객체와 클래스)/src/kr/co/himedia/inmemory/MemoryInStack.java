package kr.co.himedia.inmemory;

public class MemoryInStack {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		adder(num1, num2);
		System.out.println("---------------------");
	}
	
	public static int adder(int n1, int n2) {
		return n1 + n2;
	}
	
}
