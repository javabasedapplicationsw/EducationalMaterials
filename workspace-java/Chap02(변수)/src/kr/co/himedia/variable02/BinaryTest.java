package kr.co.himedia.variable02;

public class BinaryTest {

	public static void main(String[] args) {
		
		int a = 10;
		float f = 35.6f;
		boolean b = false;
		char c = 'A';
		String s = "APPLE";
		
		int decimal = 69;				//10진수
		System.out.println("decimal = " + decimal);
		
		int binary = 0b01000101;		//2진수
		System.out.println("binary = " + binary);
		
		int octal = 0105;				//8진수
		System.out.println("octal = " + octal);
		
		int hexa = 0x45;				//16진수
		System.out.println("hexa = " + hexa);
	}
}
