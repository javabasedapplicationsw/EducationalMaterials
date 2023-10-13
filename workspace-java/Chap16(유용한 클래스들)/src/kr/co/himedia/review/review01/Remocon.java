package kr.co.himedia.review.review01;

//추상클래스 = 추상메서드 + 구현메서드 
public abstract class Remocon {

	public abstract void channelUp();
	public abstract void channelDown();
	public abstract void volumeUp();
	public abstract void volumeDown();
	public void internet() {
		System.out.println("인터넷이 연결된다.");
	}
}
