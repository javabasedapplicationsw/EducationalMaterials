package kr.co.himedia.lambda03;

public class MyNumberTest {

	public static void main(String[] args) {
		//람다식을 인터페이스 자료형 참조 변수에 대입
		MyNumber max = (x, y) -> (x > y) ? x : y;
		
		System.out.println(max.getMax(10, 20));
	}
}
