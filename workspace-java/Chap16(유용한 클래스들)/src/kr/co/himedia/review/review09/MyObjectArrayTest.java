package kr.co.himedia.review.review09;

public class MyObjectArrayTest {

	public static void main(String[] args) {
		
		//A, B, C 객체를 배열(Object[] )에 저장하고 출력하시오.
		ObjectArray list = new ObjectArray();
		list.add(new A());		//upcasting
		list.add(new B());
		list.add(new C());
		
		A a = (A) list.get(0);		//downcasting
		a.display();
		
		B b = (B)list.get(1);
		b.display();				//downcasting

		C c = (C)list.get(2);
		c.display();				//downcasting
		
		System.out.println();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof A) {
				((A)list.get(i)).display();
			}else if(list.get(i) instanceof B) {
				((B)list.get(i)).display();
			}else
				((C)list.get(i)).display();
		}
		
		
	}
}







