package kr.co.himedia.array02;

public class BookArrayTest {
	
	public static void main(String[] args) {
		
		Book[] books = new Book[5];
		
		books[0] = new Book("초보자도 프로처럼 만드는 플러터 앱 개발", "이정주");
		books[1] = new Book("초보자도 프로처럼 만드는 플러터 앱 개발2", "이정주2");
		books[2] = new Book("초보자도 프로처럼 만드는 플러터 앱 개발3", "이정주3");
		books[3] = new Book("초보자도 프로처럼 만드는 플러터 앱 개발4", "이정주4");
		books[4] = new Book("초보자도 프로처럼 만드는 플러터 앱 개발5", "이정주5");
		
		for(int i=0; i<books.length; i++) {
			books[i].showInfo();
		}
	}

}
