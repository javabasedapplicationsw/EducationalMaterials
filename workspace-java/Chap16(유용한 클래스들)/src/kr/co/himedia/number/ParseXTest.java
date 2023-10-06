package kr.co.himedia.number;

/*
 * 	문자열을 수치형으로 변환하는 메서드 
 * 
 * 		Byte                 parseByte()				문자열을 byte형으로 변환 
 * 		Short				 parseShort()
 * 		Integer				 parseInt()
 * 		Long				 parseLong()
 * 		Float				 parseFloat()
 * 		Double				 parseDouble()	
 */
public class ParseXTest {

	public static void main(String[] args) {
		
		String str = "100";
		int a = Integer.parseInt(str);		//형변환
		double b = Double.parseDouble(str); //형변환
		
		System.out.println(a +", "+ b);
		System.out.println();
		
		Integer n1 = Integer.valueOf(5);
		Integer n2 = Integer.valueOf("2024");
		
		System.out.println("큰 수 : " + Integer.max(n1, n2));
		System.out.println("작은 수 : " + Integer.min(n1, n2));
		System.out.println("합 : " + Integer.sum(n1, n2));
		
		System.out.println("12의 2진 표현 : 0B" + Integer.toBinaryString(12));
		System.out.println("12의 8진 표현 : 0" + Integer.toOctalString(12));
		System.out.println("12의 16진 표현 : 0x" + Integer.toHexString(12));
	}
}
























