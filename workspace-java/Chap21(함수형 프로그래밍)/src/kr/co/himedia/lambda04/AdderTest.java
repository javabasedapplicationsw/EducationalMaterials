package kr.co.himedia.lambda04;

import java.util.function.Function;

public class AdderTest {

	public static void main(String[] args) {
		
		Function<Integer, Integer> myAdder = new Adder();
		int result =  myAdder.apply(5);
		System.out.println(result);
	}
}
