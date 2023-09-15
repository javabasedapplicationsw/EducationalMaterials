package kr.co.himedia.operator;

public class LogicalOperTest {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		
		boolean flag = (num1 > 0) && (num2 > 0);
		System.out.println(flag);
		
		flag = (num1 < 0) && (num2 > 0);
		System.out.println(flag);	
		
		flag = (num1 > 0) || (num2 > 0);
		System.out.println(flag);		
		
		flag = (num1 < 0) || (num2 > 0);
		System.out.println(flag);	
		
		flag = !(num1 > 0);
		System.out.println(flag);	
		
		System.out.println();
		int x=1, y=0;
		System.out.println(!(x>0));
		System.out.println(x>0 && x<3);
		System.out.println(x>0 && y<0);
		System.out.println(x<0 || y>=0);
		System.out.println(y<0 && y<=-5);
	}
}













