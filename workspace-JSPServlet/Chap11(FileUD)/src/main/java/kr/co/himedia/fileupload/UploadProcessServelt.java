package kr.co.himedia.fileupload;

import java.io.IOException;

import jakarta.servlet.ServletException;
/*
 * @MultipartConfig
 * 	- 파일업로드 처리위한 서블릿 구성 애너테이션임
 * 	- 멀티파트 요청을 처리
 * 	- Part 객체를 사용하여 업로드된 파일의 정보에 접근 할수 있음
 * 	- maxFileSize : 업로드 할 개별 파일의 최대 크기 (1MB) 
 * 	- maxRequestSize : 멀티파트 요청에 포함된 전체 파일 크기 (10MB)
 */
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileupload/uploadProcess.do")
@MultipartConfig(									
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 1024 * 10
)
public class UploadProcessServelt extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String saveDirectory = getServletContext().getRealPath("/Uploads");
			
			//파일 업로드하기
			String originalFileName = FileUtility.uploadFile(request, saveDirectory);
			
			//저장된 파일명 변경하기
			String savedFileName = FileUtility.renameFile(saveDirectory, originalFileName);
			
			//DB에 저장
			insertHiFile(request, originalFileName, savedFileName);		
			
			//파일 목록 페이지로 이동하기
			response.sendRedirect("fileList.jsp");
			
			
		} catch (Exception e) {
			System.out.println("파일 업로드 중 오류");
			request.setAttribute("errorMessage", "파일 업로드 중 오류");
			request.getRequestDispatcher("fileUploadMain.jsp").forward(request, response);
		}
		
	}

	private void insertHiFile(HttpServletRequest request, String oFileName, String sFileName) {
		//파일 외 폼값 받기
		String title = request.getParameter("title");
		
		String[] cateArray = request.getParameterValues("categori");
		StringBuffer cateBuf = new StringBuffer();
		if (cateArray == null)
			cateBuf.append("선택한 항목 없음");
		else {
			for (String s : cateArray)
				cateBuf.append(s +", ");
		}
		
		System.out.println("파일 폼외 값 : " + title +"\n"+ cateBuf);
		
		//DB 입력
		HiFileDTO dto = new HiFileDTO();
		dto.setTitle(title);
		dto.setCategory(cateBuf.toString());
		dto.setOfile(oFileName);
		dto.setSfile(sFileName);
		
		//DAO를 통해 DB에 반영
		HiFileDAO dao = new HiFileDAO();
		dao.insertFile(dto);
		dao.close();
		
	}
}


















