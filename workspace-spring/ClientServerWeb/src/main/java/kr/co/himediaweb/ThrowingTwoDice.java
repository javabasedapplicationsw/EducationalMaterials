package kr.co.himediaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThrowingTwoDice {

	@RequestMapping("/rollDice")
	public void dice(HttpServletResponse response) {
		int id1 = (int)(Math.random()*6) + 1;
		int id2 = (int)(Math.random()*6) + 1;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		
		try {
			out = response.getWriter();

			out.print("<html>");
			out.print("<head>");
			out.print("</head>");
			out.print("<body>");
			
			out.print("<img src='resources/img/dice"+id1+".jpg' />");
			out.print("<img src='resources/img/dice"+id2+".jpg' />");
			out.print("</body>");
			out.print("</html>");
			
			
		} catch (IOException e) { e.printStackTrace(); }
		
	}
}















