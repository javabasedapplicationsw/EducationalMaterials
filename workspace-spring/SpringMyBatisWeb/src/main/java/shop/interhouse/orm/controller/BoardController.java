package shop.interhouse.orm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import shop.interhouse.orm.domain.BoardDto;
import shop.interhouse.orm.domain.PageResolver;
import shop.interhouse.orm.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@PostMapping("/remove")
	public String remove(Integer bno, Integer page, Integer pageSize,
						 RedirectAttributes rattr, HttpSession session) {
		String writer = (String) session.getAttribute("id");
		String msg = "DEL_OK";
		
		try {
			if(boardService.remove(bno, writer) != 1)
				throw new Exception("Delete failed");
		} catch (Exception e) {
			e.printStackTrace();
			msg = "DEL_ERR";
		}
		
		rattr.addAttribute("page", page);
		rattr.addAttribute("pageSize", pageSize);
		//삭제 후 메시지가 한번만 나와야 함
		rattr.addFlashAttribute("msg", msg);			//한번 세션에 저장하고 없어지는 것임. 세션에도 부담이 없음. 
		return "redirect:/board/list";
	}

	@GetMapping("/read")
	public String read(Integer bno, Integer page, Integer pageSize, Model m) {
		
		try {
			BoardDto boardDto = boardService.read(bno);
			m.addAttribute(boardDto);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/board/list";
		}
		
		return "board";
	}
	
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer page,
					   @RequestParam(defaultValue = "10") Integer pageSize,
						Model m, HttpServletRequest request) {
		
		if (!loginCheck(request)) 		// 로그인 안했으면 로그인 화면으로 이동 
			return "redirect:/login/login?toURL="+request.getRequestURL();
		
		
		try {
			int totalCnt = boardService.getCount();
			m.addAttribute("totalCnt", totalCnt);
			
			PageResolver pageResolver = new PageResolver(totalCnt, page, pageSize);
			if (page < 0 || page > pageResolver.getTotalCnt())
				page = 1;
			if (pageSize < 0 || pageSize > 50)
				pageSize = 10;
			
			Map map = new HashMap();
			map.put("offset", (page-1)*pageSize);
			map.put("pageSize", pageSize);
					
			List<BoardDto> list = boardService.getPage(map);	
			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);
			
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return "boardList";				// 로그인 한 상태이면, 게시판 목록 화면으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 세션을 얻어서
		HttpSession session = request.getSession();
		// 세션에 id가 있는지 확인, 있으면 true 반환
		return session.getAttribute("id") != null;			//true면 반환, null이면 false반환 
	}
}








