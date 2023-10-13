package kr.co.himedia.review.review06;

public class IntArray {

	private final int DEFAULT_CAFACITY=5;			//상수
	private int[] elements;
	private int size=0;
	
	//생성동작
	public IntArray() {
		elements = new int[DEFAULT_CAFACITY];		//5개 크기 배열 
	}
	
	//저장동작
	public void add(int element) {
		//
		elements[size++] = element;
	}
	
	//길이를 구하는 동작 (원소의 개수)
	public int size() {
		return size;
	}
	
	//데이터를 얻는 동작
	public int get(int index) {
		//
		return elements[index];
	}
	
}


















