package kr.co.himedia.exception02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsTest {
	
	public Class loadClass(String fileName, String ClassName) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		Class clazz = Class.forName(ClassName);
		return clazz;
	}
	
	
	public static void main(String[] args) {
		ThrowsTest test = new ThrowsTest();
		
		try {
			test.loadClass("a1.txt", "java.lang.String");
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("FileNotFoundException : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("ClassNotFoundException : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		
		System.out.println("end");
	}

}






















