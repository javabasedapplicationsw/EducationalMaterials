package kr.co.himedia.goingtoacademy;

/*
 *  * 객체지향 프로그래밍에서 협력
 *  	- 객체 간에 필요한 메시지를 전송하고 이를 처리하는 기능 구현
 *  	- 매개 변수로 객체가 전달되는 경우
 *  	- 협력 예)
 *  		- 학생이 버스를 탄다
 *  		- 학생이 지하철을 탄다 
 *  	- 시나리오
 *  		- 채은이와 승덕이는 각각 버스와 지하철을 타고 학원에 갑니다.
 *  		- 채은이는 10000원을 가지고 있었고, 3321번 버스를 타면서 1250원을 지불합니다.
 *  		- 승덕이는 50000원을 가지고 있었고, 5호선 지하철을 타면서 1300원을 지불합니다.
 *  		- 두 학생이 버스와 지하철을 타는 상황을 구현하시오.	
 *  
 *  		- 이순신은 지각을 해서 택시를 타야 했습니다.
 *            20000원을 가지고 있었는데 10000원을 택시비로 사용했습니다.
 *            택시는 '하이운수' 회사 택시를 탔습니다. 
 *  
 *  	- 출력 예시
 *  		- 김채은님의 남은 돈은 8750원 입니다.
 *  		  서승덕님의 남은 돈은 48700원 입니다.
 *  		  3321번의 버스의 승객은 1명이고, 수입은 1250원입니다.
 *  		  5호선 지하철의 승객은 1명이고, 수입은 1300원입니다.	
 *  
 *  	    - 이순신님의 남은 돈은 10000원 입니다.
 *            하이택시 수입은 10000원 입니다.	  
 *  	
 *  										
 *  								버스
 *  							   ----- 
 *  	학생                         버스 번호
 *     ------                       승객 수   
 *      이름                         수입
 *      학년
 *      돈
 *  
 *  							    지하철
 *  							    -----
 *  								노선 번호
 *  								승객 수
 *  								수입  
 */

public class Student {
	
	private String studentName;
	private int grade;
	private int money;
	
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		bus.ride(1250);
		this.money -= 1250;
	}
	
	public void takeSubway(Subway subway) {
		subway.ride(1300);
		this.money -= 1300;
	}
	
	public void showInfo() {
		System.out.println(studentName +"님의 남은 돈은 " +money+ "원 입니다.");
	}
}











