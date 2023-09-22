package kr.co.himedia.userdefinetype;

public class BookTest {

	public static void main(String[] args) {
		// 책 1권을 저장할 변수를 선언
		// 한권의 책 데이터를 저장하기 위해서 객체(인스턴스)를 생성
		Book book = new Book();
		book.title = "게임 디자인, 프로토타입 제작, 개발 2/e";
		book.price = 75000;
		book.company = "에이콘 출판사";
		book.author = "제레미 깁슨 본드";
		book.page = 1356;
		book.isbn = "9791161757889";
		
		System.out.println(book.title +"\t"+ book.price +"\t"+ book.company +"\t"+ book.author +"\t"+ book.page
							+"\t"+ book.isbn);
	}
}
