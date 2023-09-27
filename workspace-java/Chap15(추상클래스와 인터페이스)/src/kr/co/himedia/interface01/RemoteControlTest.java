package kr.co.himedia.interface01;

public class RemoteControlTest {

	public static void main(String[] args) {
		
		//인터페이스도 일종의 상위급이므로 필드(변수)의 다형성이 허용됨
		RemoteControl rControl = new Audio();
		rControl.turnOn();
		rControl.setVolume(15);
		rControl.setVolume(-100);
		rControl.turnOff();
		
		System.out.println();
		
		rControl = new Television();
		rControl.turnOn();
		rControl.setVolume(9);
		rControl.setVolume(-10);
		rControl.turnOff();
	}
}
