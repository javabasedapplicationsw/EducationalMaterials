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
	
	static class InStaticClass {
		int inNum = 100;
		static int sInNum =200;
		
		//정적클래스의 일반 메서드
		void inTest() {
			//num += 10;				//외부 클래스의 인스턴스 변수는 사용불가 
			System.out.println("inStaticClass inNum = " +inNum+ "(정적 내부 클래스의 인스턴스 변수 사용)");
			System.out.println("inStaticClass sInNum = " +sInNum+ "(정적 내부 클래스의 스태틱 변수 사용)");
			System.out.println("OutClass sNum = " +sNum+ "(외부 클래스의 스태틱 변수 사용)");
		}
		
		//정적클래스의 static 메서드 
		static void sTest() {
			//num += 100;			//외부 클래스의 인스턴스 변수 사용 불가
			//inNum += 10;			//내부 클래스의 인스턴스 변수 사용 불가 
			System.out.println("OutClass sNum = " +sNum+ "(외부 클래스의 스태틱 변수 사용)");
			System.out.println("InStaticClass sNum = " +sInNum+ "(내부 클래스의 스태틱 변수 사용)");
		}
	}
	
	
	
}



public class InnerClassTest {
	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		System.out.println("외부 클래스 변수를 이용하여 내부 클래스 기능 호출");
		outClass.usingInClass(); 	// 외부클래스 이용하여 내부 클래스 메서드 호출 
		
		System.out.println();
		
		//(이미 만들어진) 외부클래스를 이용하여 내부 클래스 생성 
		OutClass.InClass inClass = outClass.new InClass();
		inClass.inTest();
		System.out.println();
		
		//외부 클래스 생성하지 않고 바로 정적 내부 클래스 생성
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		//정적 내부 클래스의 일반 메서드 호출
		sInClass.inTest();
		System.out.println();
		
		//정적 내부 클래스의 스태틱 메서드 호출
		OutClass.InStaticClass.sTest();
	}
}




















