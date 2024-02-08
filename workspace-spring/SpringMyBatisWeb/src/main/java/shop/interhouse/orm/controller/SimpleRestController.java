package shop.interhouse.orm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.interhouse.orm.domain.Person;

@Controller
public class SimpleRestController {

	@GetMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	
	@ResponseBody
	@PostMapping("/send")
	public Person test(@RequestBody Person p) {
		System.out.println("p = " + p);
		p.setName("user300");
		p.setAge(p.getAge() + 2024);
		
		return p;
	}
	
	@GetMapping("/test")
	public String test() {
		return "comment/test";
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "comment/test2";
	}	
	
	@GetMapping("/test3")
	public String test3() {
		return "comment/test3";
	}	
	
	@GetMapping("/test4")
	public String test4() {
		return "comment/test4";
	}
	
	@GetMapping("/test5")
	public String test5() {
		return "comment/test5";
	}	
}









