package kr.co.himedia.review.review04;

public class MaxMinFinderTest {

	public static void main(String[] args) {
		
		int[] arr = {4, 3, 1, 7, 9};
		int min = MaxMinFinder.findMin(arr);
		int max =  MaxMinFinder.findMax(arr);
		System.out.println(min);
		System.out.println(max);
	}
}
