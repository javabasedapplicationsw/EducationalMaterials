package kr.co.himedia.review.review04;

public class MaxMinFinder {

	 public static int findMin(int[] arr) {
		 int min = arr[0];		//최소값 초기화 
		 for(int i=1; i<arr.length; i++) {
			 if(arr[i]<min) {
				 min = arr[i];
			 }
		 }
		 return min;
	 }

	public static int findMax(int[] arr) {
		int max = arr[0];		//최대값 초기화 
		for(int i=1; i<arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		return max;
	}
}

























