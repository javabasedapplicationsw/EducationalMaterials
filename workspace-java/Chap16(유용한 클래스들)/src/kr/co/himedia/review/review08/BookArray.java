package kr.co.himedia.review.review08;

import java.util.Arrays;

public class BookArray {
	
	private final int DEFAULT_CAFACITY = 5;
	private Book[] elements;
	private int size=0;
	
	//생성동작
	public BookArray() {
		elements = new Book[DEFAULT_CAFACITY];		//5개 크기 배열
	}
	
	//저장동작
	public void add(Book element) {
		if(size == elements.length) {
			upgradeArray();
		}
		
		elements[size++] = element;
	}

	private void upgradeArray() {
		int newCapacity = elements.length * 2;
		elements = Arrays.copyOf(elements, newCapacity);		
	}

	//길이를 구하는 동작 (원소의 개수)
	public int size() {
		return size;
	}
	
	//데이터를 얻는 동작
	public Book get(int index) {		//5, -1
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("index의 범위가 초과됨");
		}
		
		return elements[index];
	}
}












