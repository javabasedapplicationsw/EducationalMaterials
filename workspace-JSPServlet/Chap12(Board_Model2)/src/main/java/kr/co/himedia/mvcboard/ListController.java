package kr.co.himedia.mvcboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.himedia.utils.BoardPage;

public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO 생성
		MvcBoardDAO dao = new MvcBoardDAO();
		
		//전달할 매개변수 저장용 map 생성
		Map<String, Object> map = new HashMap<>();
		String searchField = request.getParameter("searchField");
		String searchWord = request.getParameter("searchWord");
		if (searchWord != null) {
			//쿼리스트링으로 전달받은 매개변수 중 검색어가 있다면 map에 저장
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		
		int totalCount = dao.selectCount(map);				// 게시물 개수 
		
		//페이징 처리(시작)
		ServletContext application = getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
		
		//현재 페이지 확인
		int pageNum = 1;			// 기본값
		String pageTemp = request.getParameter("pageNum");
		if (pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp);			//요청받은 페이지로 수정
		}
		
		//목록에 출력할 게시물 범위 계산
		int start = (pageNum - 1) * pageSize + 1;			//첫 게시물 번호
		int end = pageNum * pageSize;						//마지막 게시물 번호 
		map.put("start", start);
		map.put("end", end);
		//페이징 처리(끝)
		
		List<MvcBoardDTO> boardLists = dao.selectListPage(map);
		dao.close();										//DB 연결 닫기
		
		//뷰에 전달할 내용 추가
		//바로가기 영역 HTML 문자열
		String pagingData = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "../mvcboard/list.do");
		map.put("pagingData", pagingData);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		//전달할 데이터를 request 영역에 저장 --> 이후 list.jsp로 포워드 
		request.setAttribute("boardLists", boardLists);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/mvcBoard/list.jsp").forward(request, response);
	}
}





























