package kr.co.himedia.stream03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest3 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("output3.txt");
		try(fos) {
			byte[] bs = new byte[26];
			byte data = 65;					//'A'의 아스키 코드 값
			for(int i=0; i<bs.length; i++)
				bs[i] = data++;
			
			fos.write(bs); 					//배열 한꺼번에 출력하기 
			//fos.write(bs, 2, 10);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("출력이 완료되었습니다.");
	}
}
