package kr.co.himedia.goingtoacademy02;

public class GoingToAcademyTest {

	public static void main(String[] args) {
		
		Student studentL = new Student("이순신", 20000);
		Taxi hiTaxi = new Taxi("하이미디어 운수");
		
		studentL.takeTaxi(hiTaxi);
		
		studentL.showInfo();
		hiTaxi.showTaxiInfo();
		
	}
}
