package kr.co.himedia.interface07;

import java.util.ArrayList;

//책꽃이 -- 책을 보관(자료구조, ArrayList)
public class BookShelf {

	protected ArrayList<String> bookshelf;
	
	public BookShelf() {
		bookshelf = new ArrayList<>();
	}

	public ArrayList<String> getBookshelf() {
		return bookshelf;
	}
	
	public int getCount() {
		return bookshelf.size();
	}
	
}
