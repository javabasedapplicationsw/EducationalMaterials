package kr.co.himedia.interface06;

public class HiMediaClassTest {

	public static void main(String[] args) {
		
		HiMediaClass hMClass = new HiMediaClass();
		
		X xClass = hMClass;		//upcasting
		xClass.x();
		
		Y yClass = hMClass;		//upcasting
		yClass.y();
		
		hMClass.x();
		hMClass.y();
		hMClass.myMethod();
		
	}
}
