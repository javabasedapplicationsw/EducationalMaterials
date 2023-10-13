package kr.co.himedia.review.review03;

public class ObjectToStringTest {

	public static void main(String[] args) {
		
		Board b = new Board();
		b.setTitle("가을 날씨 청정");
		System.out.println(b.getTitle());
		System.out.println(b);
		System.out.println(b.toString());
	}
}
