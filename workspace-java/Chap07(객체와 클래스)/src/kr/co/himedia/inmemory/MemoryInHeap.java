package kr.co.himedia.inmemory;

public class MemoryInHeap {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book();
		
		book1.num = 10;
		book2.num = 20;
		
		System.out.println(book1.num);
		System.out.println(book2.num);
		
		book1 = null;
		book2 = null;
	}
}
