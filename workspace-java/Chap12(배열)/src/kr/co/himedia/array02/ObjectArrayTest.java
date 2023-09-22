package kr.co.himedia.array02;

// 영화 3편을 저장할 배열을 생성하고 영화 3편의 데이터를 저장하고 출력하시오.
public class ObjectArrayTest {
	
	public static void main(String[] args) {
		
		Movie[] movies = new Movie[3];
		
		movies[0] = new Movie();
		movies[0].mtitle = "무빙";
		movies[0].mmajor = "고윤정";
		movies[0].mtime = 1000;
		movies[0].mlevel = 15;
		movies[0].mday = "2023-08-09";
		movies[0].mpart = "액션";
		
		
		movies[1] = new Movie();
		movies[1].mtitle = "무빙2";
		movies[1].mmajor = "고윤정2";
		movies[1].mtime = 10020;
		movies[1].mlevel = 15;
		movies[1].mday = "2023-08-09";
		movies[1].mpart = "액션2";
		
		movies[2] = new Movie();
		movies[2].mtitle = "무빙3";
		movies[2].mmajor = "고윤정3";
		movies[2].mtime = 10030;
		movies[2].mlevel = 15;
		movies[2].mday = "2023-08-09";
		movies[2].mpart = "액션3";	
		
		for(int i=0; i<movies.length; i++) {
			System.out.println(movies[i].mtitle +"\t"+ movies[i].mmajor +"\t"+ movies[i].mtime);
		}
		
	}

}







