package kr.co.himedia.number;

public class NumberTest {

	public static void main(String[] args) {
		
		//Integer num1 = new Integer(20);
		Integer num1 = Integer.valueOf(20);
		System.out.println(num1.intValue());
		System.out.println(num1.doubleValue());
		
		Double num2 = Double.valueOf(3.14);
		System.out.println(num2.intValue());
		System.out.println(num2.doubleValue());
	}
}
