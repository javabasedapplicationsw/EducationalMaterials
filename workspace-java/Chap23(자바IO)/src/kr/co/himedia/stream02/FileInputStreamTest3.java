package kr.co.himedia.stream02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest3 {

	public static void main(String[] args) {	
		
		try(FileInputStream fis = new FileInputStream("input.txt")) {

			//파일의 끝까지 한 바이트씩 자료 읽기
			int i;
			while((i = fis.read()) != -1)
				System.out.print((char)i);
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(" end");
	}
}








