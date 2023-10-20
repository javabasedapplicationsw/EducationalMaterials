package kr.co.himedia.stream06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamTest {

	public static void main(String[] args) {
		long millisecond = 0;
		
		try(FileInputStream fis = new FileInputStream("jsoup-1.16.1-javadoc.jar");
			FileOutputStream fos = new FileOutputStream("jsoup_copy.jar")	) {
			
			millisecond = System.currentTimeMillis();
			
			int i;
			while( (i = fis.read()) != -1)
				fos.write(i);
			
			millisecond = System.currentTimeMillis() - millisecond;
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("파일 복사하는 데 " +millisecond+ "millisecond 소요되었습니다.");
	}
}












