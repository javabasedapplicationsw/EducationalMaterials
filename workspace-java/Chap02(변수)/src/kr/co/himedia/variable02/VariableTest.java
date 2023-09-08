package kr.co.himedia.variable02;

public class VariableTest {

	public static void main(String[] args) {
		/*
		 * 변수 himedia에 10을 저장하고 himedia에 저장된 값을 
		 * 변수 hellomedia에 저장하고
		 * 변수 hellomedia에 10을 곱하여 변수 hihimedia에 저장하시오.
		 * hihimedia 값을 출력하시오.
		 */
		
		int himedia = 10;
		int hellomedia = himedia;
		int hihimedia = hellomedia * 10;
		System.out.println(hihimedia);
		
		// sum이라는 변수에 1부터 5까지의 수를 누적해서 출력하시오.
		// 초기화 : 변수를 만들고 난 후 연산을 하기 전에 값을 저장하는 행위
		int sum = 0;
		sum = sum + 1;		//0+1
		sum = sum + 2;		//1+2
		sum = sum + 3;		//3+3
		sum = sum + 4; 		//6+4
		sum = sum + 5;		//10+5
		System.out.println("sum = " + sum);
		
		// x=10, y=20을 저장하고 변수의 값을 서로 교환(swap)하여서 출력하시오.
		int x=10; 
		int y=20;
		System.out.println("x = " +x+ " , " +"y = "+ y);
		
		int tmp;
		tmp=y;
		y=x;
		x=tmp;
		System.out.println("x = " +x+ " , " +"y = "+ y);
	}
}


















