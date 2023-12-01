package kr.co.himedia.mvcboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.himedia.fileupload.FileUtility;
import kr.co.himedia.utils.JSFunction;

public class WriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/mvcBoard/write.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파일 업로드 처리
		// 업로드 디렉토리 물리적 경로 설정
		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
		String originalFileName = "";
		
		try {
			originalFileName = FileUtility.uploadFile(request, saveDirectory);
		} catch (Exception e) {
			JSFunction.alertLocation(response, "파일 업로드 오류입니다.", "../mvcboard/write.do");
			return;
		}
		
		// 2. 파일 업로드 외 처리 
		MvcBoardDTO dto = new MvcBoardDTO();
		// 폼값을 DTO에 저장
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPass(request.getParameter("pass"));
		
		// 원본 파일명과 저장된 파일이름 설정
		if (originalFileName != "") {
			// 파일명 변경
			String savedFileName = FileUtility.renameFile(saveDirectory, originalFileName);
			
			dto.setOfile(originalFileName);		//원래 파일 이름
			dto.setSfile(savedFileName);		//서버에 저장된 파일 이름 
		}
		
		// DAO를 통해 DB에 게시 내용 저장
		MvcBoardDAO dao = new MvcBoardDAO();
		int result = dao.insertWrite(dto);
		dao.close();
		
		// 성공 or 실패
		if (result == 1)			// 글쓰기 성공
			response.sendRedirect("../mvcboard/list.do");
		else 						// 글쓰기 실패
			JSFunction.alertLocation(response, "글쓰기에 실패했습니다.", "../mvcboard/write.do");
	}
}




























