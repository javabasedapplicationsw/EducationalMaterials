package kr.co.mediasignup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	//@RequestMapping(value = "/register/add3", method = {RequestMethod.GET, RequestMethod.POST})
	@RequestMapping(value = "/register/add3")
	//@GetMapping("/register/add3")
	public String register() {
		return "registerForm";
	}
	
	//@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	@PostMapping("/register/save")			// 신규 회원 등록
	public String save(User user, Model m) throws UnsupportedEncodingException {
		//1. 유효성 검사
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력했습니다.", "utf-8");
			//return "redirect:/register/add3?msg="+msg;
			return "forward:/register/add3";
			
		}
		return "registerinfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}











