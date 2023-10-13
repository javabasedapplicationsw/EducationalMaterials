package kr.co.himedia.review.review09;

import java.util.Arrays;

import kr.co.himedia.review.review08.Book;

public class ObjectArray {
	private final int DEFAULT_CAFACITY = 5;
	private Object[] elements;
	private int size=0;
	
	public ObjectArray() {
		this(5);
	}
	
	public ObjectArray(int capacity) {
		elements = new Object[capacity];		//원하는 크기의 배열을 생성함 
	}
	
	//저장하는 동작
	public void add(Object element) {
		if(size == elements.length) {
			upgradeArray();
		}
		
		elements[size++] = element;
	}

	public void upgradeArray() {
		int newCapacity = elements.length * 2;
		elements = Arrays.copyOf(elements, newCapacity);	
	}
	
	//길이를 구하는 동작 (원소의 개수)
	public int size() {
		return size;
	}
	
	//데이터를 얻는 동작
	public Object get(int index) {		//5, -1
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("index의 범위가 초과됨");
		}
		
		return elements[index];
	}
}


















