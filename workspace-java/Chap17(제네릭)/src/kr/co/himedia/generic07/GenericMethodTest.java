package kr.co.himedia.generic07;


class MyData {
	
	public static <T> T showData(T data) {
		
		if(data instanceof String)
			System.out.println("문자열");
		else if(data instanceof Integer)
			System.out.println("정수형");
		else if(data instanceof Double)
			System.out.println("실수형");
		
		return data;
	}
}

public class GenericMethodTest {
	public static void main(String[] args) {
		MyData.showData("Hi HiMedia");		//<String> 생략
		MyData.<Integer>showData(1);
		MyData.showData(1.0);				//<Double> 생략
	}
}





