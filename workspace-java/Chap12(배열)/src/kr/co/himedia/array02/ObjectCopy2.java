package kr.co.himedia.array02;

public class ObjectCopy2 {
	
	public static void main(String[] args) {
		
		Book[] libray = new Book[5];
		Book[] copylib = new Book[5];
		
		libray[0] = new Book("플러터 앱 개발", "이정주");
		libray[1] = new Book("플러터 앱 개발2", "이정주2");
		libray[2] = new Book("플러터 앱 개발3", "이정주3");
		libray[3] = new Book("플러터 앱 개발4", "이정주4");
		libray[4] = new Book("플러터 앱 개발5", "이정주5");
		
		copylib[0] = new Book();
		copylib[1] = new Book();
		copylib[2] = new Book();
		copylib[3] = new Book();
		copylib[4] = new Book();
		
		for(int i=0; i<libray.length; i++) {
			copylib[i].setTitle(libray[i].getTitle());
			copylib[i].setAuthor(libray[i].getAuthor());
		}
		
		libray[0].setTitle("iOS 앱 개발");
		libray[0].setTitle("스티브잡스");
		
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







