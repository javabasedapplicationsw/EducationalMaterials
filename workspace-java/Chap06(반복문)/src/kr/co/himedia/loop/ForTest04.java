package kr.co.himedia.loop;

public class ForTest04 {

	public static void main(String[] args) {
		
		// 2의배수를 출력하시오.
		// 초기식 생략
		int i = 0;
		for ( ; i<10; i++) {
			if(i%2 == 0)
				System.out.print(i + " ");
		}
		
		System.out.println();
		
		// 초기식, 증감식 생략 
		i = 0;
		for( ; i<10; ) {
			if(i%2 == 0)
				System.out.print(i + " ");
			i++;
		}
		
		System.out.println();
		
		// 증감식 대한 연산수식
		for(int j=0; j<10; j=j+2) {
			System.out.print(j + " ");
		}
		
	}
}














