package kr.co.himedia.loop02;

public class NestedLoopTest02 {

	public static void main(String[] args) {
		int dan = 2;
		int count = 1;
		
		for(dan=2; dan<=9; dan++) {
			for(count=1; count<=9; count++) {
				System.out.println(dan +"X"+ count +"="+ dan*count);
			}
			System.out.println();
		}
	}
}
