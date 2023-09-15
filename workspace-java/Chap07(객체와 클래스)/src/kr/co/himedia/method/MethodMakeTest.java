package kr.co.himedia.method;

public class MethodMakeTest {
	
	public static void main(String[] args) {
		int a=3;
		int b=5;
		
		int result = add(a, b);
		System.out.println("result = " + result);
	}
	
	public static int add(int x, int y) {
		int sum = x+y;
		return sum;
	}

}
