package kr.co.himedia.innerclass;


class Outter {
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num = 100;
		
		return new Runnable() {
			int localNum = 10;

			@Override
			public void run() {			// 이 run() 메서드는 나중에 또 호출될 수 있음 
				//i = 100;				// 매개변수는 상수(final)로 바뀜 
				//num = 200;			// 지역변수는 상수(final)로 바뀜 
				System.out.println("i = " + i);
				System.out.println("num = " + num);
				System.out.println("localNum = " + localNum);
				
				System.out.println("outNum = " +outNum+ "(외부 클래스의 인스턴스 변수)");
				System.out.println("Outer.sNum = " +sNum+ "(외부 클래스의 정적 변수)");
			}
			
		};		
		
	}
	
	Runnable runner = new Runnable() {			// Runnable 변수이름 => runner, 클래스 이름은 생략 ==> 익명 (내부) 클래스임 
		
		@Override
		public void run() {
			System.out.println("Runnable이 구현된 익명 클래스 변수");
			
		}
	};
}

public class AnonymousInnerClassTest {
	public static void main(String[] args) {
		Outter out = new Outter();
		Runnable runner = out.getRunnable(10);
		runner.run();
		
		out.runner.run();
	}
}









