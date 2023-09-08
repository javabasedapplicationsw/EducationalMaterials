package kr.co.himedia.variable02;

// 123을 10진수, 2진수, 8진수, 16진수로 출력하시오.
public class BinaryTest02 {

	public static void main(String[] args) {
		int data = 123;
		
		String binary = Integer.toBinaryString(data);
		System.out.println("binary = " + binary);		//0b1111011
		
		String octal = Integer.toOctalString(data);		//0173
		System.out.println("octal = " + octal);
		
		String hexa = Integer.toHexString(data);
		System.out.println("hexa = " + hexa);			//0x7b
		
		int x=123;
		System.out.println("x = " + x);
		
		int y=0b1111011;
		System.out.println("y = " + y);
		
		int z=0173;
		System.out.println("z = " + z);
		
		int zz=0x7b;
		System.out.println("zz = " + zz);
	}
}





