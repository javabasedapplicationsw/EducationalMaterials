package kr.co.himedia.gson;

import com.google.gson.Gson;

public class GsontoJsonTest {

	public static void main(String[] args) {
		
		Member memberDTO = new Member("이순신", 30, "Admiral@gmail.com");
		// JSON -> {"name":"이순신", ....}
		Gson gson = new Gson();
		String json = gson.toJson(memberDTO);
		System.out.println("json = " + json);
	}
}
