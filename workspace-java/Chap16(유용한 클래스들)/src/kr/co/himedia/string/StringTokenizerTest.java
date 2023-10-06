package kr.co.himedia.string;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		
		//StringTokenizer st1 = new StringTokenizer("a b c");			// 공백 기준 분할 
		StringTokenizer st2 = new StringTokenizer("1,2,3", ",");
		
		while(st2.hasMoreTokens())				// 토큰 유무 확인
			System.out.println(st2.nextToken());
	}
}
