package kr.co.himedia.array03;

import java.util.ArrayList;

import kr.co.himedia.array02.Book;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<Book> libray = new ArrayList<>();
		
		libray.add(new Book("초보자도 프로처럼 만드는 플러터 앱 개발", "이정주"));
		libray.add(new Book("초보자도 프로처럼 만드는 플러터 앱 개발2", "이정주2"));
		libray.add(new Book("초보자도 프로처럼 만드는 플러터 앱 개발3", "이정주3"));
		libray.add(new Book("초보자도 프로처럼 만드는 플러터 앱 개발4", "이정주4"));
		libray.add(new Book("초보자도 프로처럼 만드는 플러터 앱 개발5", "이정주5"));
		
		for(int i=0; i<libray.size(); i++)
			libray.get(i).showInfo();
	}
}
