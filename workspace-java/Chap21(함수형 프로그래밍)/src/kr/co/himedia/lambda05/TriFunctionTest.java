package kr.co.himedia.lambda05;

public class TriFunctionTest {

	public static void main(String[] args) {
		
		TriFunction<Integer, Integer, Integer, Integer> addThreeNum = (x, y, z) -> x + y + z;
		int result = addThreeNum.apply(3, 2, 5);
		System.out.println(result);
	}
}
