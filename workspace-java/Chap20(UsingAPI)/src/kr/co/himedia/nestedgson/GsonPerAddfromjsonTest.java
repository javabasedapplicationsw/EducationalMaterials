package kr.co.himedia.nestedgson;

import com.google.gson.Gson;

public class GsonPerAddfromjsonTest {

	public static void main(String[] args) {
		String json = "{\"name\":\"이순신\",\"age\":36,\"email\":\"Admiral@gmail.com\",\"address\":{\"city\":\"서울\",\"country\":\"대한민국\"}}";
		
		Gson gson = new Gson();
		//JSON -> Person
		Person person = gson.fromJson(json, Person.class);
		System.out.println("person = " + person);
	}
}
