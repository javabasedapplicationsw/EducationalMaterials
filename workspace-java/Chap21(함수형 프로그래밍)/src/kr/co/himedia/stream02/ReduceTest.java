package kr.co.himedia.stream02;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class ReduceTest {

	public static void main(String[] args) {
		String[] greetings = {"안녕하세요 올해도 다사다난한 한 해 였네요", "hello", "Good Afternoon", "반갑습니다.^^"};
		System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) -> {
										if(s1.getBytes().length >= s2.getBytes().length) return s1;
										else return s2;
										}));
		
		String str = Arrays.stream(greetings).reduce(new CompareString()).get();
		System.out.println(str);
	}
}

// 배열에 있는 여러 문자열에서 길이가 가장 긴 문자열 찾기
class CompareString implements BinaryOperator<String> {

	@Override
	public String apply(String s1, String s2) {
		if(s1.getBytes().length >= s2.getBytes().length) return s1;
		else return s2;
	}
	
}







