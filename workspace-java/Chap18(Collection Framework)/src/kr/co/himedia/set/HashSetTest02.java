package kr.co.himedia.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest02 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,2,4,6,7,1,3};
		
		//hashSet 객체 생성
		Set<Integer> uniqueNum = new HashSet<>();
		for(int number : nums)
			uniqueNum.add(number);
		
		System.out.println("유일한 숫자들...");
		for(int number : uniqueNum)
			System.out.print(number + "\t");
	}
}
