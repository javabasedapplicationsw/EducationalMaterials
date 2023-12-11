package com.ai.remote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1.원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 100;					// 인스턴스 변수
	static int cv = 200;			// static 변수 

	// 2.URL과 메서드를 연결
	@RequestMapping("/okay")
	private void himedia() {			// 인스턴스 메서드 - 인스턴스 변수, static 변수 둘다 사용 가능  		
		System.out.println("Okay! Hi Media!");
		System.out.println(iv);
		System.out.println(cv);
	}
}
