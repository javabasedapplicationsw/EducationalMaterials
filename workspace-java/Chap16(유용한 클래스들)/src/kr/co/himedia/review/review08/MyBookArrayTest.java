package kr.co.himedia.review.review08;

public class MyBookArrayTest {

	public static void main(String[] args) {
		
		BookArray list = new BookArray();	//Book, 길이 5
		
		list.add(new Book("챗GPT 거부할 수 없는 미래", 17100, "길벗", "서지영"));
		list.add(new Book("챗GPT 거부할 수 없는 미래2", 17100, "길벗2", "서지영2"));
		list.add(new Book("챗GPT 거부할 수 없는 미래3", 17100, "길벗3", "서지영3"));
		list.add(new Book("챗GPT 거부할 수 없는 미래3", 17100, "길벗3", "서지영4"));
		list.add(new Book("챗GPT 거부할 수 없는 미래3", 17100, "길벗3", "서지영5"));
		list.add(new Book("챗GPT 거부할 수 없는 미래3", 17100, "길벗3", "서지영6"));
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
		System.out.println(list.get(11));
	}
}














