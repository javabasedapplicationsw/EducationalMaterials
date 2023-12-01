package kr.co.himedia.mvcboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.himedia.fileupload.FileUtility;
import kr.co.himedia.utils.JSFunction;

@WebServlet("/mvcboard/pass.do")
public class PassController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mode", request.getParameter("mode"));
		request.getRequestDispatcher("/mvcBoard/pass.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//매개변수 저장
		String id = request.getParameter("id");
		String mode = request.getParameter("mode");
		String pass = request.getParameter("pass"); 
		
		MvcBoardDAO dao = new MvcBoardDAO();
		boolean confirmed = dao.confirmPassword(pass, id);
		dao.close();
		
		//비밀번호 일치
		if (confirmed) {
			if (mode.equals("edit")) {				// 수정모드
				HttpSession session = request.getSession();
				session.setAttribute("pass", pass);
				response.sendRedirect("../mvcboard/edit.do?id=" + id);
			}
			else if (mode.equals("delete")) {		// 삭제모드
				dao = new MvcBoardDAO();
				MvcBoardDTO dto = dao.selectView(id);
				int result = dao.deleteBoard(id);	// 게시물 삭제
				dao.close();
				// 게시물 삭제 성공 시 첨부파일도 삭제하기
				if (result == 1) {
					String saveFileName = dto.getSfile();
					FileUtility.deleteFile(request, "/Uploads", saveFileName);
				}
				JSFunction.alertLocation(response, "삭제되었습니다.", "../mvcboard/list.do");
			}
		}
		else {			//비밀번호 불일치
			JSFunction.alertBack(response, "비밀번호 검증에 실패했습니다.");
		}
	}
}




















