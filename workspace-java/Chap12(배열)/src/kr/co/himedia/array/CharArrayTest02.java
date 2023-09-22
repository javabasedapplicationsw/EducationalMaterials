package kr.co.himedia.array;

/*
 * Quiz) char[] 배열에 APPLE이라는 문자로 초기화 하시오.
 *       대문자로 된 APPLE을 소문자 apple로 출력하시오.  
 */

public class CharArrayTest02 {
	
	public static void main(String[] args) {
		char[] ch = {'A', 'P', 'P', 'L', 'E'};
		
		System.out.print((char)(ch[0]+32));
		System.out.print((char)(ch[1]+32));
		System.out.print((char)(ch[2]+32));
		System.out.print((char)(ch[3]+32));
		System.out.println((char)(ch[4]+32));
		
		for(int i=0; i<ch.length; i++) {
			System.out.print((char)(ch[i]+32));
		}
	}

}
