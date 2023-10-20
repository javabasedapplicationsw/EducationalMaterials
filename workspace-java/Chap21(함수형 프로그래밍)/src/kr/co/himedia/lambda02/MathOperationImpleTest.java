package kr.co.himedia.lambda02;

public class MathOperationImpleTest {

	public static void main(String[] args) {
		
		MathOperation mo = new MathOperationImple();
		int result = mo.operation(10, 20);
		
		System.out.println("result = " + result);
	}
}
