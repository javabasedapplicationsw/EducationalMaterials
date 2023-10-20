package kr.co.himedia.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		int sum = list.stream().mapToInt(n -> n.intValue()).sum();
		System.out.println(sum);
		System.out.println();
		
		List<String> sList = new ArrayList<>();
		sList.add("이순신 장군");
		sList.add("나대용 구선 제작자");
		sList.add("권율");
		
		Stream<String> stream = sList.stream();
		stream.forEach(s -> System.out.print(s + "\t"));
		System.out.println();
		
		sList.stream().sorted().forEach(s -> System.out.print(s + "\t"));
		System.out.println();
		
		sList.stream().map(s -> s.length()).forEach(n -> System.out.print(n + "\t"));
		System.out.println();
		
		sList.stream().filter(s -> s.length() >= 7).forEach(s -> System.out.print(s + "\t"));
	}
}

























