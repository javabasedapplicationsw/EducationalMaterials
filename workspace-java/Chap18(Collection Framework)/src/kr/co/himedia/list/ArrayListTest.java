package kr.co.himedia.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		//객체 저장 : 순서 있음. 중복 허용
		list.add("orange");
		list.add("apple");
		list.add("apple");
		list.add("banana");
		
		//객체 참조
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i) + "\t");
		System.out.println();
		
		//첫번째 객체 삭제
		list.remove(0);
		//삭제 후 객체 참조 
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i) + "\t");	
		System.out.println();
		
		list.set(1, "orange");
		for(String str : list)
			System.out.print(str.toString() + "\t");
		
	}
}




























