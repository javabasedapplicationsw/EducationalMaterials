package kr.co.himedia.conversion;

public class TypeConversionTest {

	public static void main(String[] args) {
		
		byte bNum = 10;
		int iNum = bNum;
		
		int iNum1 = 20;
		float fNum = iNum1;
		
		double dNum = 30;				//int => double 자동 형변환 
		System.out.println(dNum);
		
	}
}
