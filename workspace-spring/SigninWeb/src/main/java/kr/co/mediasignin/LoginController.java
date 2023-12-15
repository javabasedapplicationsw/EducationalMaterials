package kr.co.mediasignin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, 
						HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		// 1. id와 pwd를 확인
		// 2-1.	일치하지 않으면, loginForm으로 이동
		if (!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다", "utf-8");
			return "redirect:/login/login?msg="+msg;			
		}
				
		// 2-2. 일치하면 로그인 후 홈화면으로 이동
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		return "hm".equals(id) && "0305".equals(pwd);
	}
}

























