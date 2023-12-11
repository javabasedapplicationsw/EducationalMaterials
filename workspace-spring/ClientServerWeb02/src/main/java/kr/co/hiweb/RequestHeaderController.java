package kr.co.hiweb;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {

	@RequestMapping("/reqeustheader")
	public void himedia(HttpServletRequest request) {
		
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name +" : "+ request.getHeader(name));
		}
	}
}
