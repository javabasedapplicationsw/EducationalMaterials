package kr.co.himedia.generic03;

public class ObjectArrTest {

	public static void main(String[] args) {
		
		ObjectArr<String> array = new ObjectArr<>(5);
		array.set(0, "Hello");
		array.set(1, "HiMedia");
		array.set(2, "Java");
		array.set(3, "Generic");
		
		for(int i=0; i<array.size(); i++) {
			System.out.println(array.get(i));
		}
	}
}
