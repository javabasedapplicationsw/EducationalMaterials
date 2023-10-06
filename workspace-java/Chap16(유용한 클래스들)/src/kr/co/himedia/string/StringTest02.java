package kr.co.himedia.string;

public class StringTest02 {

	public static void main(String[] args) {
		String java = new String("java");
		String kotlin = new String("kotlin");
		System.out.println(System.identityHashCode(java));
		
		java = java.concat(kotlin);
		System.out.println(java);
		System.out.println(System.identityHashCode(java));
		
	}
}
