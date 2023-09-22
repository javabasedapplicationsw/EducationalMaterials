package kr.co.himedia.userdefinetype03;

public class MovieTest {
	
	public static void main(String[] args) {
		// 한 편의 영화 데이터를 저장하고 출력하시오.
		
		Movie movie = new Movie();
		movie.mtitle = "오펜하이머";
		movie.mday = "2023.08.15";
		movie.mmajor = "킬리언 머피";
		movie.mpart = "스릴러";
		movie.mtime = 180;
		movie.mlevel = 15;
		System.out.println(movie.mtitle+"\t"+movie.mday+"\t"+movie.mmajor+"\t"+movie.mpart+"\t"+movie.mtime
							+"\t"+movie.mlevel);
	}

}
