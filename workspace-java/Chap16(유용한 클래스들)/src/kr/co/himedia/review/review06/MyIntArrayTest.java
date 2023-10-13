package kr.co.himedia.review.review06;

public class MyIntArrayTest {

	public static void main(String[] args) {
		//배열을 사용하지 않고 (IntArray) API를 사용해서 배열을 동작시키기 
		
		//정수 5개를 배열에 저장하고 출력하시오.
		IntArray intArr = new IntArray();
		
		intArr.add(1);
		intArr.add(2);
		intArr.add(3);
		intArr.add(4);
		intArr.add(5);
		
		intArr.add(6);					//예외 발생(ArrayIndexOutOfBoundsException)
		

		System.out.println(intArr.get(0));
		System.out.println(intArr.get(1));
		System.out.println(intArr.get(2));
		System.out.println(intArr.get(3));
		System.out.println(intArr.get(4));
		System.out.println(intArr.size());
	}
}
