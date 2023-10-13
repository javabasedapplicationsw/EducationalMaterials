package kr.co.himedia.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		
		Map<String, Integer> stuScores = new HashMap<>();
		stuScores.put("KiM", 95);
		stuScores.put("Lee", 85);
		stuScores.put("Park", 90);
		stuScores.put("Choi", 80);
		
		System.out.println("Kim' score: " + stuScores.get("KiM"));
		System.out.println("Lee' score: " + stuScores.get("Lee"));
		
		stuScores.put("Park", 92);		//수정
		System.out.println("Park' score: " + stuScores.get("Park"));
		
		stuScores.remove("Choi");
		System.out.println("Choi' score: " + stuScores.get("Choi"));
		
		System.out.println();
		
		for(Map.Entry<String, Integer> entry : stuScores.entrySet() ) {
			System.out.println(entry.getKey() +"'s score : "+ entry.getValue());
		}
	}
}









