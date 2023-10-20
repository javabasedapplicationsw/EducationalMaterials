package kr.co.himedia.stream06;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) throws IOException {
		
		File directory = new File("C:/Temp1/directory");
		File file1 = new File("C:/Temp1/file1.txt");
		File file2 = new File("C:/Temp1/file2.txt");
		
		if(directory.exists() == false) {
			directory.mkdirs();
		}
		
		if(file1.exists() == false) {
			file1.createNewFile();
			System.out.println("file1.txt가 생성되었습니다.");
		}
		
		if(file2.exists() == false) {
			file2.createNewFile();
			System.out.println("file2.txt가 생성되었습니다.");
		}
		
		File temp = new File("C:\\apache-tomcat-10.1.13");
		
		File[] contents = temp.listFiles();
		
		System.out.println("날짜 \t 시간   \t\t   크기    \t   이름");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		System.out.println("----------------------------------------------");
		for(File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t" + file.getName());
			} else {
				System.out.print("\t\t" +file.length()+ "\t" + file.getName());
			}
			System.out.println();
		}
	}
}





















