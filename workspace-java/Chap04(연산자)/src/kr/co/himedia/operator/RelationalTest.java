package kr.co.himedia.operator;

public class RelationalTest {

	public static void main(String[] args) {
		
		int num1 = 5;
		int num2 = 3;
		int a = 4;
		
		boolean value = (num1 > num2);
		System.out.println(value);
		
		System.out.println(num1 < num2);
		System.out.println(num1 >= num2);
		System.out.println(num1 == num2);
		System.out.println(num1 != num2);
		
		System.out.println();
		System.out.println(a>5);
		System.out.println(a<5);
		System.out.println(a==6);
		System.out.println(a!=4);
		System.out.println(3>=a);
		System.out.println(a<=a+1);
		
		System.out.println();
		System.out.println((1.0 == 1));		//실수형으로 자동 형변환이 이뤄지고 그다음 비교 연산함 
		System.out.println((1.0 != 1));
		
	}
}








