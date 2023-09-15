package kr.co.himedia.conversion;

public class TypeChange {

	public static void main(String[] args) {
		byte num1 = 1;
		byte num2 = 2;
		//byte result1 = num1 + num2;
		byte result1 = (byte)(num1 + num2);		//강제 형변환 
		
		int num3 = 1;
		int num4 = 2;
		int result2 = num3 + num4;
		
		long num5 = 1;
		long num6 = 2;
		long result3 = num3 + num4;				//자동 형변환 
		
		char c = 'A';
		int cc = c;								//자동 형변환 
		System.out.println("자동 형변환 cc = " + cc);
		
		float num7 = 1.0f;
		float num8 = 2.0f;
		
		double num9 = 1.0;
		double num10 = 2.0;
		double result4 = num7 + num8;			//자동 형변환
		
		float x = 15.6f;
		int y = (int)x;							//강제 형변환(손실)
		System.out.println("강제 형변환 y = " + y);
		
		double dx = 14.67;
		int dy = (int)dx;
		System.out.println("강제 형변환 dy = " + dy);   //강제 형변환(손실)
		
	}
}













