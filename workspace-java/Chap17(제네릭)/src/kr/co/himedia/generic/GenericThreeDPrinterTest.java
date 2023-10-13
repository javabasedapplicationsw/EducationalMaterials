package kr.co.himedia.generic;

import kr.co.himedia.nongeneric.Plastic;
import kr.co.himedia.nongeneric.Powder;

public class GenericThreeDPrinterTest {

	public static void main(String[] args) {
		
		GenericThreeDPrinter<Powder> powderPrinter = new GenericThreeDPrinter<>();
		powderPrinter.setMaterial(new Powder());
		System.out.println(powderPrinter);
		
		GenericThreeDPrinter<Plastic> plasticPrinter = new GenericThreeDPrinter<>();
		plasticPrinter.setMaterial(new Plastic());
		System.out.println(plasticPrinter);
		
		GenericThreeDPrinter<Water> waterPrinter = new GenericThreeDPrinter<>();
		
		// 제네릭에서 자료형 추론
		GenericThreeDPrinter printer = new GenericThreeDPrinter<>();
		printer.setMaterial(new Powder());
		
		var printer2 = new GenericThreeDPrinter();
		printer2.setMaterial(new Plastic());
	}
}






