package kr.co.himedia.mvcboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.himedia.fileupload.FileUtility;
import kr.co.himedia.utils.JSFunction;

@WebServlet("/mvcboard/edit.do")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 1024 * 10
)
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MvcBoardDAO dao = new MvcBoardDAO();
		MvcBoardDTO dto = dao.selectView(id);
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/mvcBoard/edit.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파일 업로드 처리
		// 업로드 디렉토리의 물리적 경로 확인 		
		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
		
		// 파일 업로드
		String originalFileName = "";
		
		try {
			originalFileName = FileUtility.uploadFile(request, saveDirectory);
		} catch (Exception e) {
			JSFunction.alertBack(response, "파일 업로드 오류입니다.");
			return;
		}
		
		//2. 파일 업로드 외 처리
		//수정 내용을 매개변수에서 얻어오기
		String id = request.getParameter("id");
		//System.out.println("id = " + id);
		String prevofile = request.getParameter("prevofile");
		String prevsfile = request.getParameter("prevsfile");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 비밀번호는 session에서 가져오기
		HttpSession session = request.getSession();
		String pass = (String) session.getAttribute("pass");
		
		//DTO에 저장
		MvcBoardDTO dto = new MvcBoardDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPass(pass);
		
		// 원본파일명과 저장된 파일 이름 설정
		if (originalFileName != "") {
			String savedFileName = FileUtility.renameFile(saveDirectory, originalFileName);
			
			dto.setOfile(originalFileName);			//변경된 원래 파일 이름
			dto.setSfile(savedFileName);			//변경된 서버에 저장된 파일 이름
			
			//기존 파일 삭제
			FileUtility.deleteFile(request, "/Uploads", prevsfile);
		}
		else {
			//첨부파일이 없으면 기존 이름 유지
			dto.setOfile(prevofile);
			dto.setSfile(prevsfile);
		}
		
		//DB에 수정 내용 반영
		MvcBoardDAO dao = new MvcBoardDAO();
		int result = dao.updateBoard(dto);
		dao.close();
		
		//수정성공
		if (result == 1) {
			session.removeAttribute("pass");
			response.sendRedirect("../mvcboard/view.do?id=" + id);
		}
		else {		// 수정 실패
			JSFunction.alertLocation(response, "비밀번호 검증을 다시 진행해주세요.", "../mvcboard/view.do?id=" + id);
		}
	}
	
}



































