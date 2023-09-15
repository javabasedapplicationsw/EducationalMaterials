package kr.co.himedia.operator;

public class ArithmeticOperTest {
	
	public static void main(String[] args) {
		
		int num1 = 7;
		int num2 = 3;
		int result;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 * num2 = " + (num1 * num2));
		System.out.println("num1 / num2 = " + (num1 / num2));		//나누기
		System.out.println("num1 % num2 = " + (num1 % num2));		//나머지 
		
		// 예외 처리 코드
		try {
			result = 10 / 0;					// 산술 연산 예외 발생하는 부분 
		} catch(ArithmeticException e) {
			System.out.println("예외 발생 : " + e);
		}
		
		
	}

}
