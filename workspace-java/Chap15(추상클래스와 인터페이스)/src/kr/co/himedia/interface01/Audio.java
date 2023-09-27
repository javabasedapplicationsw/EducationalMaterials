package kr.co.himedia.interface01;

public class Audio implements RemoteControl {

	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");	
	}

	@Override
	public void setVolume(int volume) {

		//볼륨이 0~10 사이에서만 움직일 것
		if(volume > RemoteControl.MAX_VOLUMN) {
			System.out.println("Audio 볼륨의 최대치 값은 10입니다.");
			this.volume = RemoteControl.MAX_VOLUMN;
		}
		else if(volume < RemoteControl.MIN_VOLUMN) {
			System.out.println("Audio 볼륨의 최소치 값은 0입니다.");
			this.volume = RemoteControl.MIN_VOLUMN;
		}
		else {
			this.volume = volume;
		}
		
		System.out.println("현재 Audio 볼륨 : " + this.volume );
	}

}











