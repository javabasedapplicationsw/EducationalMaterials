package kr.co.himedia.global;

public class NonStaticTest {
	
	public static void main(String[] args) {
	
		int a = 10;
		int b = 20;
		
		NonStaticTest nst = new NonStaticTest();
		int sum = nst.hap(a, b);
		System.out.println(sum);
	}
	
	public int hap(int x, int y) {
		int result = x + y;
		return result;
	}

}
