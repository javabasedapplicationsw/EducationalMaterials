package kr.co.himedia.loop;

// 1 ~ 10까지의 합을 출력하시오.
public class ForTest03 {

	public static void main(String[] args) {
		
		int sum = 0;
		int count = 1;
		
		for(int i=0; i<10; i++) {
			sum += count;
			count++;
		}
		System.out.println(sum);
		System.out.println("===================");
		
		sum = 0;
		count = 1;
		
		/*
		 * for문의 문장들은 생략가능함
		 * 	1) 초기화식 생략 
		 * 		- 이미 이전에 값이 초기화 되어 for 내부에서 값을 지정할 필요가 없는 경우 
		 */
		int i = 0;
		for( ; i < 10; i++, count++) {
			sum += count;
		}
		
		System.out.println(sum);
		System.out.println("===================");	
		
		sum = 0;
		count = 1;		
		
		/*
		 *  2) 조건식 생략
		 *  	- 반복 수행에 대한 조건이 수행문 내부에 있는 경우 
		 */
		for(i = 0; ; i++) {
			sum += i;
			if (i >= 10) break;
		}
		System.out.println(sum);
		System.out.println("===================");		
		
		/*
		 *  3) 증감식 생략
		 *  	- 증감식에 대한 연산이 복잡하거나 다른 변수의 연산 결과값에 결정되는 경우
		 */
		sum = 0;
		count = 1;
		
		for(i = 0; i<=10; ) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		
//		for( ; ; ) {
//			//무한반복
//		}
	}
}





















