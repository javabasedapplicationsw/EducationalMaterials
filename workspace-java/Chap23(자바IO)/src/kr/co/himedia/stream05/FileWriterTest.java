package kr.co.himedia.stream05;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		
		try(FileWriter fw = new FileWriter("write.txt")) {
			fw.write('A');						//문자 하나 출력
			
			char[] buf = {'B', 'C', 'D', 'E', 'F', 'G'};
			fw.write(buf);						//문자 배열 출력 
			
			fw.write(" 안녕하세요. 좋은 목요일입니다."); //String 출력 
			fw.write(buf, 1, 2);
			fw.write("65");						// 숫자를 그대로 출력	
			
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("출력이 완료되었습니다.");
	}
}
