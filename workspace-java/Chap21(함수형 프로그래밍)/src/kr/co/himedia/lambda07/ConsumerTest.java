package kr.co.himedia.lambda07;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		
		Consumer<String> myConsumer = (String str) -> System.out.println(str);
		myConsumer.accept("Good Afternoon!");
		myConsumer.accept("Seoul Korea!");
		
		Consumer<Integer> myConsumer2 = x -> System.out.println("정수형 입력값 처리 : " + x);
		myConsumer2.accept(23);
		System.out.println();
		
		List<Integer> list = Arrays.asList(4, 2, 3);
		spend(list, myConsumer2);
		System.out.println();
		
		List<Double> dlist = Arrays.asList(1.1, 2.2, 3.3);
		Consumer<Double> myConsumer3 = x -> System.out.println("더블형 리스트 입력값 처리 : " + x);
		spend(dlist, myConsumer3);
		
		
	}
	
	public static<T> void spend(List<T> inputs, Consumer<T> consumer) {
		for (T input : inputs)
			consumer.accept(input);
	}
}













