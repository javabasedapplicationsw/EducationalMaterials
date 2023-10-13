package kr.co.himedia.generic04;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		List<Movie> list = new ArrayList<>();
		list.add(new Movie("명랑", "김한민", "2014-07-30", "한국"));
		list.add(new Movie("명랑2", "김한민2", "2014-07-30", "한국2"));
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
}
