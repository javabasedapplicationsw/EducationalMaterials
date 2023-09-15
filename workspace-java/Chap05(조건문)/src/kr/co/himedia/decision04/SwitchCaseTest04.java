package kr.co.himedia.decision04;

import java.util.Scanner;

/*
 * Quiz)
 * 	- switch~case문을 활용하여 요일에 해당하는 운동을 출력하시오.
 * 		- Sunday : 야구하기 
 * 		- Monday : 농구하기
 * 		- Tuesday : 수영하기
 * 		- Wednesday : 수영하기 
 * 		- Friday : 휴식
 * 		- Saturday : 휴식
 */
public class SwitchCaseTest04 {

	public static void main(String[] args) {
		System.out.print("요일을 입력하세요 (Sunday, Monday, Tuesday, Wednesday) : ");
		Scanner scan = new Scanner(System.in);
		
		String day = scan.nextLine();
		switch(day) {
			case "Sunday":
				System.out.println("야구하기");
				break;
			case "Monday":
				System.out.println("농구하기");
				break;
			case "Tuesday": case "Wednesday":
				System.out.println("수영하기");
				break;
			default:
				System.out.println("휴식");			
		}
		
		scan.close();
	}
}













