package kr.co.himedia.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		Stream<String> strStream = Stream.of("곧 연말이", "다가 옵니다.", "연휴가 그때 또 있겠죠?");
		List<String> str = strStream.collect(Collectors.toList());
		System.out.println(str);
		
		String[] cityArray = new String[] {"서울", "뉴욕", "파리"};
		Stream<String> cityStream = Arrays.stream(cityArray);
		List<String> cityList = cityStream.collect(Collectors.toList());
		System.out.println(cityList);
	}
}
