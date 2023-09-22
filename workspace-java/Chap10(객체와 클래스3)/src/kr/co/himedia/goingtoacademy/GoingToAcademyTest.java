package kr.co.himedia.goingtoacademy;

public class GoingToAcademyTest {

	public static void main(String[] args) {
		Student student = new Student("김채은", 10000);
		Student student2 = new Student("서승덕", 50000);
		Bus bus3321 = new Bus(3321);
		Subway subway5 = new Subway(5);
		
		student.takeBus(bus3321);
		student2.takeSubway(subway5);
		
		student.showInfo();
		student2.showInfo();
		bus3321.showInfo();
		subway5.showInfo();
		
	}
}
