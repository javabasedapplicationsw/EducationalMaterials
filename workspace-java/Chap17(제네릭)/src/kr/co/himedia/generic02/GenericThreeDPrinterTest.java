package kr.co.himedia.generic02;

public class GenericThreeDPrinterTest {

	public static void main(String[] args) {
		
		GenericThreeDPrinter<Powder> powderPrinter = new GenericThreeDPrinter<>();
		powderPrinter.setMaterial(new Powder());
		System.out.println(powderPrinter);
		powderPrinter.print();
		
		GenericThreeDPrinter<Plastic> plasticPrinter = new GenericThreeDPrinter<>();
		plasticPrinter.setMaterial(new Plastic());
		System.out.println(plasticPrinter);
		plasticPrinter.print();
		
		
	}
}
