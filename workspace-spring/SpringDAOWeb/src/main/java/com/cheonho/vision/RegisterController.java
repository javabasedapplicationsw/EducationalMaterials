package com.cheonho.vision;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	UserDao userDao;
	
	public final int FAIL = 0;
	
	@GetMapping(value = "/add")
	public String register() {
		return "registerForm";
	}
	
	@InitBinder		//자동검증 (Validator를 적용하는 방법)
	public void registerValidate(WebDataBinder binder) {			//WebDataBinder : 데이터의 변환, 검증기능
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//스프링이 제공하는 CustomDateEditor를 이용해서 변환. String -> Date
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.setValidator(new UserValidator());	//UserValidator를 validator로 등록
	}
	
	
	@PostMapping("/add")	//자동 검증
	public String save(@Valid User user, BindingResult result, Model m) throws UnsupportedEncodingException {
		//1. 유효성 검사 => 관심사(UserValidator)로 분리
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		//2. DB에 새회원 정보 저장
		if (!result.hasErrors()) {	//User 객체를 검증한 결과 에러가 있으면  registerForm를 이용해서 에러를 보여줘야함 
			int rowCnt = userDao.insertUser(user);
			
			if (rowCnt != FAIL) return "registerinfo";			
		}

		return "registerForm";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}











