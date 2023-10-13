package kr.co.himedia.generic02;

public class Powder extends Material {

	@Override
	public void doPrint() {
		System.out.println("Powder 재료로 출력합니다.");
	}

	@Override
	public String toString() {
		return "재료는 Powder 입니다.";
	}

	
}
