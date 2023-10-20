package kr.co.himedia.lambda02;

@FunctionalInterface			// 함수형 인터페이스
public interface MathOperation {
	public int operation(int x, int y);				//추상 메서드 
}
