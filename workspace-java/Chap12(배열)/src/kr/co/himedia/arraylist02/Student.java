package kr.co.himedia.arraylist02;

import java.util.ArrayList;

public class Student {
	
	private int studentId;
	private String studentName;
	private ArrayList<Book> bookList;

	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		bookList = new ArrayList<>();
	}
	
	public void addBook(String title, String author) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		bookList.add(book);
	}
	
	public void showInfo() {
		System.out.print(this.studentName + "학생이 읽은 책은 : ");
		
		for(Book book : bookList) {
			System.out.print(book.getTitle() + " ");
		}
		System.out.println(" 입니다.");
	}
}






















