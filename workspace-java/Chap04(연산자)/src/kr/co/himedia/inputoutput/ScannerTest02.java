package kr.co.himedia.inputoutput;

import java.util.Scanner;

public class ScannerTest02 {

	public static void main(String[] args) {
		
		//도서정보 입력받기
		Scanner scanner = new Scanner(System.in);
		System.out.print("제목 : ");
		String title = scanner.nextLine();
		System.out.println("title = " + title);
		
		
		System.out.print("가격 : ");
		int price = scanner.nextInt();
		System.out.println("price = " + price);
		
		scanner.nextLine();
		
		System.out.print("출판사 : ");
		String company = scanner.nextLine();
		System.out.println("company = " + company);
		
		System.out.print("저자 : ");
		String author = scanner.nextLine();
		System.out.println("author = " + author);
		
		System.out.print("쪽수 : ");
		int page = scanner.nextInt();
		System.out.println("page = " + page);
		
		scanner.nextLine();
		
		System.out.print("ISBN : ");
		String isbn = scanner.nextLine();
		System.out.println("isbn = " + isbn);		
		
		scanner.close();
	}
}















