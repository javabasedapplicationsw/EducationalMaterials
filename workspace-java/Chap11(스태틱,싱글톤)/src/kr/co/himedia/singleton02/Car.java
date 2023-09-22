package kr.co.himedia.singleton02;
/*
 * 자동차 공장이 있습니다.
 * 자동차 공장은 유일한 객체이고, 이 공장에서 생산되는 자동차는 생산될 때마다 고유의 차번호가 부여됩니다.
 * 
 * 자동차 번호가 1001부터 시작되어 차가 생산될 때마다
 * 1002, 1003번 이렇게 번호가 부여되도록 자동차 공장 클래스(싱글톤 패턴), 자동차 클래스(static 변수)를 구현하시오.
 * 
 * 
 * - 출력예시 
 * 		1001
 * 		1002
 * 
 * 
 */
public class Car {

	private static int serialNum = 1000;
	private int carNum;
	
	public Car() {
		serialNum++;
		carNum = serialNum;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
	
}













