package kr.co.himedia.lambda02;

// MathOperation 인터페이스를 익명내부클래스로 구현
public class MathOperationImpleTest02 {

	public static void main(String[] args) {
		
		MathOperation mo = new MathOperation() {
			
			@Override
			public int operation(int x, int y) {
				
				return x+y;
			}
		};
		
		int result = mo.operation(100, 200);
		System.out.println("result = " + result);
	}
}
