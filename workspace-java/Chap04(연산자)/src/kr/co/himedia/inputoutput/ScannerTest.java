package kr.co.himedia.inputoutput;

import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();			// block 상태
		System.out.println("입력받은 num = " + num);
		
		System.out.print("실수를 입력하세요 : ");
		float fNum = scan.nextFloat();		// block 상태
		System.out.println("입력받은 fNum = " + fNum);
		
		System.out.print("문자열을 입력하세요 : ");			// "A", "ABC"
		String str = scan.next();
		System.out.println("입력받은 str = " + str);
		
		scan.nextLine();			//버퍼비우기 (스트림 비우기)
		
		System.out.print("문자열을 입력하세요 : ");	
		String str2 = scan.nextLine();
		System.out.println("입력받은 str2 = " + str2);
		
		scan.close();
	}

}



















