package kr.co.himedia.operator02;

public class PlusMinusSignTest {

	public static void main(String[] args) {
		short num = 5;
		
		System.out.println(+num);
		System.out.println(-num);	//부호를 바꿔서 얻은 결과를 출력
		System.out.println(num);	//num값은 변하지 않음 
		
		num = (short) -num;
		System.out.println(num);
	}
}
