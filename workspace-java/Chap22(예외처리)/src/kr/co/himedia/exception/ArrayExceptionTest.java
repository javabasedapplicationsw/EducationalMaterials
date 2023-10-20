package kr.co.himedia.exception;

public class ArrayExceptionTest {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		try {
			for(int i=0; i<=5; i++)
				System.out.println(arr[i]);			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			System.out.println("예외처리함");
		}

		
		System.out.println("프로그램 정상 종료");
	}
}
