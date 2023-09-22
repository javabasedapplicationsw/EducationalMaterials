package kr.co.himedia.reference;

/*
 * 1) 학생이 수강한 과목들에 대한 성적을 산출하는 경우
 *    --         --         
 * 2) 학생 클래스의 속성 
 * 	- 학번, 이름, 국어성적, 수학성적, 수강하는 과목 이름
 * 
 * 	==> 학생 클래스 + 과목 클래스
 * 	    ---------  ---------
 *      학번         과목 이름   
 *      이름         과목 점수   
 *      국어 과목
 *      수학 과목
 * 
 */
public class Student {
	
	int studentId;
	String studentName;
	
	Subject korea;
	Subject math;
	
	public Student(int id, String name) {
		studentId = id;
		studentName = name;
		
		korea = new Subject();
		math = new Subject();		
	}
	
	public void setKoreaSubject(String name, int score) {
		korea.subjectName = name;
		korea.score = score;
	}
	
	public void setMathSubject(String name, int score) {
		math.subjectName = name;
		math.score = score;
	}
	
	public void showScore() {
		int total = korea.score + math.score;
		System.out.println(studentName +" 학생의 총점은 "+total+ "점 입니다.");
	}
	
}





























