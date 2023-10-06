package kr.co.himedia.string;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		String java = new String("java");
		String android = new String("android");
		
		StringBuilder buffer = new StringBuilder(java);
		System.out.println(System.identityHashCode(buffer));
		buffer.append(android);
		System.out.println(buffer);
		System.out.println(System.identityHashCode(buffer));
	}
}
