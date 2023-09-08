package kr.co.himedia;

public class VariableTest {

	public static void main(String[] args) {
		int age, count = 0;			//초기화를 하지 않으면 쓰레기 값이 들어 감. 연산이 불가능 
		age = 10;
		
		int level = 10000;
		
		System.out.println(age);
		System.out.println(level);
		System.out.println(count);
		System.out.println(age + level);
	}
}
