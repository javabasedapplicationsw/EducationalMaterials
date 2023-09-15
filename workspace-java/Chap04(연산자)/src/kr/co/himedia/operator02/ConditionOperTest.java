package kr.co.himedia.operator02;

public class ConditionOperTest {
	
	public static void main(String[] args) {
		
		int num1 = 50;
		int num2 = 100;
		
		int bigNum = (num1 > num2) ? num1 : num2;
		System.out.println("큰 수 : " + bigNum);
		
		int diffNum = (num1 > num2) ? (num1 - num2) : (num2 - num1);
		System.out.println("두 수의 차 : " + diffNum);
		
		
	}

}
