package kr.co.himedia.interface07;

public class MyBookshelfTest {

	public static void main(String[] args) {
		
		Queue bQueue = new MyBookshelf();
		bQueue.enQueue("핸즈온 머신러닝");
		bQueue.enQueue("생성 AI를 활용한 나만의 콘텐츠 만들기");
		bQueue.enQueue("만들면서 배우는 생성 AI");
		bQueue.enQueue("생성 AI를 활용한 나만의 콘텐츠 만들기2");
		bQueue.enQueue("만들면서 배우는 생성 AI2");
		
		System.out.println(bQueue.getSize());
		
		System.out.println(bQueue.deQueue());
		System.out.println(bQueue.getSize());
		
		System.out.println(bQueue.deQueue());
		System.out.println(bQueue.getSize());
		
		System.out.println(bQueue.deQueue());
		System.out.println(bQueue.deQueue());
		System.out.println(bQueue.deQueue());
		System.out.println(bQueue.getSize());
	}
}







