package kr.co.himedia.decision03;

import java.util.Scanner;

public class IfElseIfTest02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이를 입력해 주세요: ");
		int age = scan.nextInt();
		int charge;
		
		if(age < 8) {
			charge = 1000;
			System.out.println("미취학 아동입니다.");
		}
		else if (age < 14) {
			charge = 2000;
			System.out.println("초등학생 입니다.");
		}
		else if (age < 20) {
			charge = 2500;
			System.out.println("중고등학생 입니다.");			
		}
		else {
			charge = 3000;
			System.out.println("일반인입니다.");
		}
		
		
		System.out.println("입장료는 " +charge+ "원입니다.");
		
		scan.close();
	}
}
