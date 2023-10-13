package kr.co.himedia.innerclass;

class OutClass {
	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;
	public OutClass() {
		inClass = new InClass();					// 내부 클래스 생성
	}
	
	class InClass {									// inner class : 외부 클래스가 생성된 후 생성 
		int inNum = 100;
		//static int sInNum = 200;					// 에러 남
		void inTest() {
			System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 클래스 변수)");
			System.out.println("InClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수)");
			System.out.println();
		}
	}
	
	public void usingInClass() {
		inClass.inTest(); 				// 내부클래스 변수를 사용하여 내부클래스 메서드 호출하기
	} 
}



public class InnerClassTest {
	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		outClass.usingInClass(); 	// 외부클래스 이용하여 내부 클래스 메서드 호출 
	}
}




















