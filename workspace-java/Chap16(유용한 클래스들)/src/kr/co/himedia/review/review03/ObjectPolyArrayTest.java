package kr.co.himedia.review.review03;

public class ObjectPolyArrayTest {

	public static void main(String[] args) {
		//다형성 배열
		Object[] obj = new Object[2];
		obj[0] = new A();		//Upcasting
		//((A)obj[0]).printHi();
		obj[1] = new B();		//Upcasting
		//((B)obj[1]).pringHi();
		
		display(obj);
		
		
	}

	private static void display(Object[] obj) {
		for(int i=0; i<obj.length; i++) {
			if(obj[i] instanceof A)
				((A)obj[i]).printHi();
			else 
				((B)obj[i]).pringHi();
		}
	}
}








