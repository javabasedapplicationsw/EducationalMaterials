package kr.co.himedia.thread;

public class RunnableInterface {
	
	public static void main(String[] args) {
		
		Runnable task = () -> {
			
			try {
				Thread.sleep(3000);				// 스레드의 실행이 3초 동안 일시 정지했다가 다시 진행함
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int sum = 0;
			for(int i=1; i<=10; i++)
				sum += i;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + sum);
		};
		
		Thread thread = new Thread(task);
		thread.start();
		
		System.out.println(Thread.currentThread().getName());
	}

}






