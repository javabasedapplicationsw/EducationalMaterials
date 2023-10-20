package kr.co.himedia.lambda04;

import java.util.function.Function;

public class Adder implements Function<Integer, Integer>{

	@Override
	public Integer apply(Integer x) {
		return x + 10;
	}
	

}
