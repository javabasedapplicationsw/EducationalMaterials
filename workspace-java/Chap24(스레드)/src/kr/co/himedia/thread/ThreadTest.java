package kr.co.himedia.thread;

class MyThread extends Thread {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " start!!");
		
		int i;
		for(i = 0; i<200; i++)
			System.out.print(i + "\t");
		
		System.out.println(Thread.currentThread() + " end!!");
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread() + " start!!");
		
		MyThread thread = new MyThread();
		thread.start();
		
		MyThread thread2 = new MyThread();
		thread2.start();
		
		System.out.println(Thread.currentThread() + " end!!");
	}
}







