package kr.co.himedia.stream;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest03 {

	public static void main(String[] args) {
		System.out.println("입력 후 '끝'이라고 쓰세요.");
		int i;
		
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			while((i = isr.read()) != '끝') {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
