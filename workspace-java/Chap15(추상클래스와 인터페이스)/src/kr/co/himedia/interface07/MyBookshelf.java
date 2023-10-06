package kr.co.himedia.interface07;

public class MyBookshelf extends BookShelf implements Queue {

	@Override
	public void enQueue(String title) {
		bookshelf.add(title);	
	}

	@Override
	public String deQueue() {		
		return bookshelf.remove(0);
	}

	@Override
	public int getSize() {
		return getCount();
	}

}
