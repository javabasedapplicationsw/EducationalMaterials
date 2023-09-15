package kr.co.himedia.inputoutput;

import java.util.Scanner;

/*
 * next() : 공백을 기준으로 해서 문자열을 입력(단어 입력시 사용)
 * nextLine() : 엔터키를 입력할때까지 문자열을 입력(문장 입력시 사용)
 */
public class ScannerTest04 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열을 입력 : ");
		String str = scan.nextLine();
		System.out.println("사용자로부터 입력받은 문자열 : " + str);
		
		int result = 100;
		System.out.print("문자열을 입력(숫자) : ");
		String temp = scan.nextLine();
		
		int str2 = Integer.parseInt(temp);		//문자열로 입력받은 숫자들을 문자열이 아니라 숫자로 바꿔주는 역할하는 메서드 
		
		int total = result + str2;
		System.out.println("연산 결과 : " + total);
		
		scan.close();
	}

}
