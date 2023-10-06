package kr.co.himedia.interface04;

public class CompleteCalculatorTest {
	
	public static void main(String[] args) {
		
		Calc calc = new CompleteCalculator();
		
		int num1= 10, num2=2;
		System.out.println(num1 +"+"+ num2 +"="+ calc.add(num1, num2));
		System.out.println(num1 +"-"+ num2 +"="+ calc.substract(num1, num2));
		System.out.println(num1 +"*"+ num2 +"="+ calc.times(num1, num2));
		System.out.println(num1 +"/"+ num2 +"="+ calc.divide(num1, num2));
		
		calc.description();
		
		int[] array = {1, 2, 3, 4, 5};
		int sum = Calc.total(array);
		System.out.println(sum);
	}

}
