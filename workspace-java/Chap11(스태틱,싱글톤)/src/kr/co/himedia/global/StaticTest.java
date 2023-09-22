package kr.co.himedia.global;

public class StaticTest {
	
	public static void main(String[] args) {
	
		int a = 10;
		int b = 20;
		
		int sum = StaticTest.hap(a, b);
		System.out.println(sum);
	}
	
	public static int hap(int x, int y) {
		int result = x + y;
		return result;
	}

}
