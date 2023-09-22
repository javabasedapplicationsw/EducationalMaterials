package kr.co.himedia.array02;

public class ObjectCopy {
	
	public static void main(String[] args) {
		
		Book[] libray = new Book[5];
		Book[] copylib = new Book[5];
		
		libray[0] = new Book("플러터 앱 개발", "이정주");
		libray[1] = new Book("플러터 앱 개발2", "이정주2");
		libray[2] = new Book("플러터 앱 개발3", "이정주3");
		libray[3] = new Book("플러터 앱 개발4", "이정주4");
		libray[4] = new Book("플러터 앱 개발5", "이정주5");
		
		System.arraycopy(libray, 0, copylib, 0, 5);
		
		for(Book book : libray) {
			book.showInfo();
		}
		
		System.out.println();
		
		for(Book book : copylib) {
			book.showInfo();
		}		
		
		libray[0].setTitle("안드로이드 앱 개발");
		libray[0].setAuthor("하이미디어");
		
		System.out.println("================================");
		for(Book book : libray) {
			book.showInfo();
		}
		
		System.out.println();
		
		for(Book book : copylib) {
			book.showInfo();
		}
	}

}







