package kr.co.himedia.array04;

/*
  
*
*	*
*	*	*
*	*	*	*
*	*	*	*	*

 */



public class TwoDimensionTest03 {

	public static void main(String[] args) {
		int[][] arr = new int[5][];
		arr[0] = new int[1];
		arr[1] = new int[2];
		arr[2] = new int[3];
		arr[3] = new int[4];
		arr[4] = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = '*';
				System.out.print((char)arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}






















