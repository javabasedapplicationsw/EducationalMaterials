package kr.co.himedia.list;

import java.util.ArrayList;

public class MovieListTest {

	public static void main(String[] args) {
		
		ArrayList<Movie> list = new ArrayList<>();
		list.add(new Movie("명랑", "김한민", "2014-07-30", "한국"));
		list.add(new Movie("명랑2", "김한민2", "2014-07-30", "한국2"));
		list.add(new Movie("명랑3", "김한민3", "2014-07-30", "한국3"));
		
		for(Movie m : list)
			System.out.println(m);
		
		System.out.println();
		
		String searchTitle = "명랑3";
		for(Movie m : list) {
			if(m.getTitle().equals(searchTitle)) {
				System.out.println("제목 : " + m.getTitle());
				System.out.println("감독 : " + m.getDirector());
				System.out.println("개봉년도 : " + m.getYear());
				System.out.println("국가 : " + m.getCountry());
			}
		}
		
	}
}























