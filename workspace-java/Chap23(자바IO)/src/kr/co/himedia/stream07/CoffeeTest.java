package kr.co.himedia.stream07;

public class CoffeeTest {

	public static void main(String[] args) {
		
		Coffee kenyaAmericano = new KeyaAmericano();
		kenyaAmericano.brewing();
		System.out.println();
		
		Coffee kenyaLatte = new Latte(kenyaAmericano);
		kenyaLatte.brewing();
		System.out.println();
		
		Coffee kenyaMocha = new Mocha(new Latte(kenyaAmericano));
		kenyaMocha.brewing();
		System.out.println();
		
		Coffee etiopiaWhippedMocha = new WhippedCream(new Mocha(new Latte(new EtiopiaAmericano())));
		etiopiaWhippedMocha.brewing();
	}
}


























