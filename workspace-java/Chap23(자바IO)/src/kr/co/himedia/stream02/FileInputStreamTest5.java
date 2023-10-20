package kr.co.himedia.stream02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest5 {

	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("input2.txt")) {
			byte[] bs = new byte[10];
			int i;
			
			//파일에서 바이트 배열로 자료 읽기 (배열에 남아 있는 자료가 출력됨)
			while((i = fis.read(bs)) != -1) {
				for(int k=0; k<i; k++)
					System.out.print((char)bs[k]);
				System.out.println(" : " +i+ "바이트 읽음");
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}








