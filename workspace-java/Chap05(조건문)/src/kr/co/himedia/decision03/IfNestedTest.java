package kr.co.himedia.decision03;

import java.util.Scanner;

public class IfNestedTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요 : ");
		int score = scan.nextInt();
		
		if(score >= 0 && score <= 100) {
			if(score >= 90) {
				if(score >= 95) {
					System.out.println("당신은 A+ 등급입니다.");
				} else {
					System.out.println("당신은 A0 등급입니다.");
				}
			}
			else if(score >= 80) {
				if(score >= 85) {
					System.out.println("당신은 B+ 등급입니다.");
				} else {
					System.out.println("당신은 B0 등급입니다.");
				}
			}
			else {
				System.out.println("더욱 분발해 주세요.");
			}
					
		} else {
			System.out.println("잘못 입력 하셨습니다.");
		}

		
		scan.close();
	}
}
