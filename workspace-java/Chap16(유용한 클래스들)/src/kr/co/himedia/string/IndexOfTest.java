package kr.co.himedia.string;

public class IndexOfTest {

	public static void main(String[] args) {
		
		String str = "AppleBananaOrange";
		int num1 = str.indexOf("a");					// "a"의 위치 반환
		int num2 = str.indexOf("a", num1 + 1);			// 첫 "a"의 그다음 "a" 위치 반환
		
		System.out.println(num1);
		System.out.println(num2);
	}
}
