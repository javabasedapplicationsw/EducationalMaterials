package kr.co.himedia.stream;

import java.io.IOException;

public class SystemInTest02 {

	public static void main(String[] args) {
		System.out.println("알파벳 여러개를 쓰고 [Enter]를 누르시오.");
		int i;
		
		try {
			while((i = System.in.read()) != '\n') {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
