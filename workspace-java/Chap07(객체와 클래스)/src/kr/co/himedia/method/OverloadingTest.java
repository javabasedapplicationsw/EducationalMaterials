package kr.co.himedia.method;

public class OverloadingTest {

	public static void main(String[] args) {
		float result = add(35.6f, 56.7f);
		System.out.println("result = " + result);
		
		int result2 = add(10, 50);
		System.out.println("result2 = " + result2);
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static float add(float a, float b) {
		return a + b;
	}
}
