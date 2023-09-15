package kr.co.himedia.decision03;

import java.util.Scanner;

/*
 * Quiz)
 * 	- 80점 이상의 학생 중에서 90점 이상은 A반, 85점 이상은 B반, 그렇지 않으면 C반으로 편성하고
 *    점수가 80 미만이면 불합격 처리하는 프로그램을 작성하시오.
 *    단, 점수는 0~100점 사이값으로 입력을 받는다.
 *    
 *  - 출력예시)
 *  	점수를 입력하세요 : 70
 *  	불합격입니다.
 *  
 *  	점수를 입력하세요 : 90  
 *  	A반 편성입니다.

 *  	점수를 입력하세요 : 85 
 *  	B반 편성입니다. 
 *  
 *  	점수를 입력하세요 : 84 
 *  	C반 편성입니다.  
 *  
 *  	점수를 입력하세요 : 200 
 *  	유효한 점수가 아닙니다.	  
 */
public class IfNestedTest03 {

	public static void main(String[] args) {
		System.out.print("점수를 입력하세요 : ");
		
		Scanner scan = new Scanner(System.in);
		
		int jumsu = scan.nextInt();
		if(jumsu >=0 && jumsu <= 100) {
			if(jumsu >= 80) {
				if(jumsu >= 90) {
					System.out.println("A반 편성입니다.");
				} else if(jumsu >= 85) {
					System.out.println("B반 편성입니다.");
				} else {
					System.out.println("C반 편성입니다.");
				}
			} else {
				System.out.println("불합격입니다.");
			}
		} else {
			System.out.println("유효한 점수가 아닙니다.");
		}
		
		scan.close();
	}
}




















