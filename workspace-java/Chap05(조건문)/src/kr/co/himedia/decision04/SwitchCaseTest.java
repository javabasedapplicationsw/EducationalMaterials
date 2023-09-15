package kr.co.himedia.decision04;

import java.util.Scanner;

//한달이 몇일인지 알려주는 프로그램
public class SwitchCaseTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("월 : ");
		int month = scanner.nextInt();
		
		switch(month) {
			case 2:
				System.out.println("28일까지입니다.");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30일까지입니다.");
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("31일까지입니다.");
				break;				
		}
				
		scanner.close();
	}
}





