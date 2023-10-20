package kr.co.himedia.lambda07;

import java.util.function.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		
		Supplier<String> mySupplier = () -> "Hello HiHiMedia";
		System.out.println(mySupplier.get());
		
		Supplier<Double> mySupplier2 = () -> Math.random();
		System.out.println(mySupplier2.get());
		System.out.println();
		
		printRamdonDouble(mySupplier2, 10);
	}
	
	public static void printRamdonDouble(Supplier<Double> supplier, int count) {
		for(int i=0; i<count; i++)
			System.out.println(supplier.get());
	}

}
