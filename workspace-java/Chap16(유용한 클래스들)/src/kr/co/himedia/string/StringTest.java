package kr.co.himedia.string;

public class StringTest {
	
	public static void main(String[] args) {
		
		String str1 = new String("himedia");
		String str2 = new String("himedia");
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		
		String str3 = "himedia";
		String str4 = "himedia3";
		
		System.out.println(str3 == str4);			//주소값 비교
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str4));
	}

}
