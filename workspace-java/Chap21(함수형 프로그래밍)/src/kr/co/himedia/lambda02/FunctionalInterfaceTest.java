package kr.co.himedia.lambda02;

public class FunctionalInterfaceTest implements MathOperation {

	public static void main(String[] args) {
		MathOperation mo = new FunctionalInterfaceTest();
		int result = mo.operation(10, 20);
		System.out.println("result = " + result);
	}

	@Override
	public int operation(int x, int y) {
		return x+y;
	}
}
