package kr.co.himedia.number;

public class BoxingUnboxingTest {

	public static void main(String[] args) {
		
		//박싱 - 기본 자료형의 값이 박싱에 의해 클래스 자료형으로 대입함 
		Integer iObj = Integer.valueOf(10);
		Double dObj = Double.valueOf(3.14);
		
		// 값을 출력함. 래퍼 클래스 toString() 메서드가 오보라이딩으로 재정의 됨 => 기본형 자료의 값이 출력됨 
		System.out.println(iObj.toString() +", "+ dObj.toString());
		
		//언박싱 - 래퍼 클래스의 메서드를 통해 기본 자료형의 값을 구함 
		int num1 = iObj.intValue();
		double num2 = dObj.doubleValue();
	}
}
