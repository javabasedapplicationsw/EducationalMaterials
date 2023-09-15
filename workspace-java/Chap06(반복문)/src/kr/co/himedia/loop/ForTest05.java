package kr.co.himedia.loop;

public class ForTest05 {

	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
			
		//Quiz1) 알파벳 대문자와 아스키 코드 값을 출력하시오.
		/*
		 *   A:65
		 *   B:66
		 *   C:67
		 *   .
		 *   .
		 *   .
		 *   Z:90
		 */
	
		for(char c='A'; c<='Z'; c++) {
			System.out.println(c + ":" + (int)c);
		}
		
		System.out.println();
		
		for(char c='a'; c<='z'; c++) {
			System.out.println(c + ":" + (int)c);
		}	
		
		System.out.println();
		
		for(int i=65; i<=90; i++) {
			System.out.println((char)i + ":" + i);
		}
		
	}
}













