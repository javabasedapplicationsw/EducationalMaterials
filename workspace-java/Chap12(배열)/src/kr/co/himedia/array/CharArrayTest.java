package kr.co.himedia.array;

//문자 배열을 만들어 A~Z까지 배열에 저장하고 출력하시오.
public class CharArrayTest {
	
	public static void main(String[] args) {
		
		char[] charArr = new char[26];
		char ch = 'A';
		
		for(int i=0; i<charArr.length; i++) {
			charArr[i] = ch++;
		}
		
		for(int i=0; i<charArr.length; i++) {
			System.out.println(charArr[i] +", "+ (int)charArr[i]);
		}
		
		System.out.println();
		
		// 향상된 for 문 사용
		for(char alpha : charArr) {
			System.out.println(alpha +", "+ (int)alpha);
		}
	}

}













