package kr.co.himedia.arraylist02;

/*
 *  HiMedia 학원에 학생이 3명 있습니다.
 *  각 학생마다 읽은 책을 기록하고 있습니다.
 *  학생마다 읽은 책을 Student 클래스 내에 ArrayList를 생성하여 관리하도록 합니다.
 *  
 *  결과예시)
 *  	Lee 학생이 읽은 책은 : 운영체제1, 운영체제2 입니다.
 *  	Shin 학생이 읽은 책은 : 딥러닝1, 딥러닝2, 딥러닝3 입니다.
 *  	Kim 학생이 읽은 책은 : 머신러닝1, 머신러닝2, 머신러닝3, 머신러닝4, 머신러닝5, 머신러닝6 입니다.
 */

public class StudentTest {

	public static void main(String[] args) {
		Student studentL = new Student(20231001, "Lee");
		studentL.addBook("운영체제1", "강민철 ");
		studentL.addBook("운영체제2", "강민철 ");
		
		Student studentS = new Student(20232001, "Shin");
		studentS.addBook("딥러닝1", "쿠날 사와르카르");
		studentS.addBook("딥러닝2", "쿠날 사와르카르");
		studentS.addBook("딥러닝3", "쿠날 사와르카르");
		
		Student studentK = new Student(20233001, "Kim");
		studentK.addBook("머신러닝1", "오렐리앙 제롱 ");
		studentK.addBook("머신러닝2", "오렐리앙 제롱 ");
		studentK.addBook("머신러닝3", "오렐리앙 제롱 ");
		studentK.addBook("머신러닝4", "오렐리앙 제롱 ");
		studentK.addBook("머신러닝5", "오렐리앙 제롱 ");
		studentK.addBook("머신러닝6", "오렐리앙 제롱 ");
		
		studentL.showInfo();
		studentS.showInfo();
		studentK.showInfo();
	}
}






















