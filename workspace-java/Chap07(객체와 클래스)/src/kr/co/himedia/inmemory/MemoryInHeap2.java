package kr.co.himedia.inmemory;

public class MemoryInHeap2 {

	public static void main(String[] args) {
		Book book1 = new Book();			//객체 생성
		book1.num = 10;
		
		Book book2 = book1;					//객체에 객체 대입 
		
		System.out.println("book1.num : "+ book1.num);
		System.out.println("book2.num : "+ book2.num);
		
		book2.num = 20;
	
		System.out.println("book1.num : "+ book1.num);
		System.out.println("book2.num : "+ book2.num);
		

	}
}
