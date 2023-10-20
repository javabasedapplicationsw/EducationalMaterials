package kr.co.himedia.stream04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try(FileInputStream fis = new FileInputStream("InstallShield.log");
			FileOutputStream fos = new FileOutputStream("InstallShield_copy.log")) {
			
			byte[] readBytes = new byte[100];
			int data = 0;
			
			while((data = fis.read(readBytes)) != -1) {
				fos.write(readBytes);
				System.out.println("읽은 바이트 수 : " + data);
			}
			
			fos.flush();
			System.out.println("복사본 파일이 생성 되었습니다.");
		}
	}

}























