package kr.co.himedia.interface08;

public class LeastCall implements Distribution {

	@Override
	public void getNextCall() {
		System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다.");	
	}

	@Override
	public void sendCalltoAgent() {
		System.out.println("현재 상담업무가 없거나 상대대기가 가장 적은 상담원에게 할당합니다.");
	}

}
