package kr.co.himedia.set;

import java.util.HashSet;

public class HashSetTest03 {

	public static void main(String[] args) {
		
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add(new String("이순신"));
		hashSet.add(new String("이도"));
		hashSet.add(new String("신사임당"));
		hashSet.add(new String("세종대왕"));
		hashSet.add(new String("세종대왕"));
		
		System.out.println(hashSet);
	}
}
