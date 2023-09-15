package kr.co.himedia.loop04;

// Quiz) 1~100사이의 5와 7의 배수를 출력하고 해당 개수도 출력하시오. (5와 7의 공배수) 
/*
 *   35
 *   70
 *   count : 2 
 */
public class WhileTest02 {

	public static void main(String[] args) {
		
		int num=0;
		int count=0;
		
		while((num++) < 100) {
			if(((num % 5) !=0) || ((num % 7) !=0)) continue;
//			if((num % 5) !=0) continue;
//			if((num % 7) !=0) continue;
			count++;				// 5와 7의 배수이면 실행
			System.out.println(num);
		}
		System.out.println("count : " + count);
	}
}



























