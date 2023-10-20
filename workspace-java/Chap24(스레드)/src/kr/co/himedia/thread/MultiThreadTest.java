package kr.co.himedia.thread;

/*
 *   - 20미만 짝수 출력 (0, 2, 4 ~ 18)
 *   - 10미만 수 출력 (9~1)   
 */
public class MultiThreadTest {

	public static void main(String[] args) {
		
		Runnable task1 = () -> {
			for(int i=0; i<20; i+=2) {					//20미만 짝수 출력
				System.out.print(i + " ");
				try {
					Thread.sleep(1000);					//1000밀리세컨드(1초) 쉼
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable task2 = () -> {
			for(int i=9; i>0; i--) {					//10미만 수 출력
				System.out.print("(" +i+ ")");
				try {
					Thread.sleep(500);					//500밀리세컨드 쉼
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread thread = new Thread(task1);
		Thread thread2 = new Thread(task2);
		thread.start();
		thread2.start();
	}
}








