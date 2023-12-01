package kr.co.himedia.mvcboard;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 선택한 게시물 불러오기
		MvcBoardDAO dao = new MvcBoardDAO();
		
		String id = request.getParameter("id");
		dao.updateVisitCount(id);				// 조회수 1 증가 
		MvcBoardDTO dto = dao.selectView(id);
		dao.close();
		
		// 줄바꿈 처리
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		// 첨부파일 확장자 추출 및 이미지 타입 확인
		String ext = null, fileName = dto.getSfile();				// 20231129_104351227.jpg
		if (fileName != null) 
			ext = fileName.substring(fileName.lastIndexOf(".")+1);
		String[] mineStr = {"png", "jpg", "gif"};
		List<String> mineList = Arrays.asList(mineStr);
		boolean isImage = false;
		if (mineList.contains(ext))
			isImage = true;
		
		// 게시물(dto) 저장 후 view.jsp 포워드
		request.setAttribute("dto", dto);
		request.setAttribute("isImage", isImage);
		request.getRequestDispatcher("/mvcBoard/view.jsp").forward(request, response);
	}
}

















