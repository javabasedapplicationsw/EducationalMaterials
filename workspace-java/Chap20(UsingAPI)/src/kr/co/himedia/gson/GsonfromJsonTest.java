package kr.co.himedia.gson;

import com.google.gson.Gson;

public class GsonfromJsonTest {

	public static void main(String[] args) {
		String json = "{\"name\":\"이순신\",\"age\":30,\"email\":\"Admiral@gmail.com\"}";
		// JSON -> Object(Member)
		Gson gson = new Gson();
		Member memberDTO = gson.fromJson(json, Member.class);
		System.out.println("memberDTO = " + memberDTO);
	}
}
