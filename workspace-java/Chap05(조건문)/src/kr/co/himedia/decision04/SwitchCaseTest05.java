package kr.co.himedia.decision04;

import java.util.Scanner;

public class SwitchCaseTest05 {

	public static void main(String[] args) {
		
		System.out.print("달 입력 : ");
		Scanner scanner = new Scanner(System.in);
		
		int month = scanner.nextInt();
		
		int day = switch(month) {
			case 1,3,5,7,8,10,12 -> {
				System.out.println("한달은 31일입니다.");
				yield 31;
			}
			case 4,6,9,11 -> {
				System.out.println("한달은 30일입니다.");
				yield 30;
			}
			case 2 -> {
				System.out.println("한달은 28일입니다.");
				yield 28;
			}
			default -> {
				System.out.println("존재하지 않는 달입니다.");
				yield 0;
			}
		};
		System.out.println(month +"월은 "+day+ "일입니다.");
		
		scanner.close();
	}
}













