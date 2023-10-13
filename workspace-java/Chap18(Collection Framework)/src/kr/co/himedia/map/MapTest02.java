package kr.co.himedia.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {

	public static void main(String[] args) {
		
		Map<Character, Integer> charCountMap = new HashMap<>();
		String str = "Hello, Himedia";
		char[] strArray = str.toCharArray();
		
		for(char c : strArray) {
			if(charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c)+1);
			}else 
				charCountMap.put(c, 1);
		}
		
		System.out.println("각 Character 갯수");
		for(char c : charCountMap.keySet()) {
			System.out.println(c +" : "+ charCountMap.get(c));
		}
	}
}











