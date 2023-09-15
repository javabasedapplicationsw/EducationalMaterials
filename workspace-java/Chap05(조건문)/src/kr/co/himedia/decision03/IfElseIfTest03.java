package kr.co.himedia.decision03;

import java.util.Scanner;
/*
 * validation
 * 	- 유효성 체크 
 * 	- 정확한 값 범위를 사용하는 것임
 * 	- 값의 범위가 연속적이지 않고 띄엄띄엄 있을 때 사용
 */
public class IfElseIfTest03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요 : ");
		int score = scanner.nextInt();
		
		if(score >= 90 && score <= 100) {
			System.out.println("등급은 A입니다.");
		} 
		else if(score >= 80 && score < 90) {
			System.out.println("등급은 B입니다.");			
		}
		else if(score >= 70 && score < 80) {
			System.out.println("등급은 C입니다.");					
		}
		else if(score >= 60 && score < 70) {
			System.out.println("등급은 D입니다.");					
		}
		else if(score >= 0 && score < 60) {
			System.out.println("등급은 F입니다.");			
		}
		else {
			System.out.println("잘못 입력 하셨습니다.");
		}
		
		System.out.println("====================================================");
		
		if(score >= 0 && score <= 100) {
			if(score >= 90)
				System.out.println("A");
			else if(score >= 80)
				System.out.println("B");
			else if(score >= 70)
				System.out.println("C");
			else if(score >= 60)
				System.out.println("D");
			else
				System.out.println("F");
		} else {
			System.out.println("잘못 입력 하셨습니다.");
		}
		
		scanner.close();
	}
}





















