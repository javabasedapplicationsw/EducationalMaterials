package kr.co.himedia.array;

class Box {}

public class ArrayTest {
	
	public static void main(String[] args) {
		//정수 5개를 저장할 배열 생성하시오.
		int[] arr1 = new int[5];
		
		//반복문 활용
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = 10;
			//System.out.println(arr1[i]);
		}
		
		// 배열 생성 및 초기화 (방법1) -- 뒤에 초기화하는 데이터 개수를 보고 생략된 숫자 유추함 
		int[] arr2 = new int[] {1, 2, 3, 4, 5};
		for(int i=0; i<arr2.length; i++) {
			//System.out.print(arr2[i] + " ");
		}
		
		// 배열 생성 및 초기화 (방법2) -- new int[] 생략가능 
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		for(int i=0; i<arr3.length; i++) {
			//System.out.print(arr3[i] + " ");
		}
		
		// 배열 선언 후 배열을 생성 -- new int[] 생략불가 
		int[] arr4;
		arr4 = new int[] {1, 2, 3, 4, 5};
		for(int i=0; i<arr4.length; i++) {
			//System.out.print(arr4[i] + " ");
		}		
		
		//길이가 7인 double형 1차원 배열 생성하시오 (arr5)
		double[] arr5 = new double[7];
		
		//길이가 9인 float형 1차원 배열 생성하시오 (arr6)
		//배열의 참조 변수와 객체 생성 분리해서 생성하시오.
		float[] arr6;
		arr6 = new float[9];
		
		//객체 대상 1차원 배열
		Box[] arr7 = new Box[5];
		
		//배열의 사이즈 출력
		System.out.println("배열 arr1 길이 : " + arr1.length);
		System.out.println("배열 arr2 길이 : " + arr2.length);
		System.out.println("배열 arr3 길이 : " + arr3.length);
		System.out.println("배열 arr4 길이 : " + arr4.length);
		System.out.println("배열 arr5 길이 : " + arr5.length);
		System.out.println("배열 arr6 길이 : " + arr6.length);
		System.out.println("배열 arr7 길이 : " + arr7.length);
	}

}























