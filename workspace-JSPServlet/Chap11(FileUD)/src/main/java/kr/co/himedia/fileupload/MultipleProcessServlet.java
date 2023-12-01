package kr.co.himedia.fileupload;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileupload/multipleProcess.do")
@MultipartConfig(									
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 1024 * 10
)
public class MultipleProcessServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//Uploads 디렉토리의 물리적 경로 가져오기
			String saveDirectory = getServletContext().getRealPath("/Uploads");
			
			//다중 파일 업로드 하기
			ArrayList<String> listFileName = FileUtility.multipleFile(request, saveDirectory);
			
			//파일 갯수만큼 반복
			for(String originalFileName : listFileName) {
				//저장된 파일명 변경하기
				String savedFileName = FileUtility.renameFile(saveDirectory, originalFileName);
				
				//DB에 저장하기
				insertHiFile(request, originalFileName, savedFileName);
			}
			
			// 파일 목록 페이지로 이동하기
			response.sendRedirect("fileList.jsp");
			
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "(멀티) 파일 업로드 오류");
			request.getRequestDispatcher("multiUploadMain.jsp").forward(request, response);
		}
		


		
	}

	private void insertHiFile(HttpServletRequest request, String oFileName, String sFileName) {
		// 파일 외 폼값 받기
		String title = request.getParameter("title");
		String[] cateArray = request.getParameterValues("categori");
		StringBuffer cateBuf = new StringBuffer();
		if (cateArray == null)
			cateBuf.append("선택한 항목 없음");
		else {
			for(String s : cateArray)
				cateBuf.append(s + ", ");
		}
		
		System.out.println("파일 외 폼값 : " +title +"\n"+ cateBuf);
		
		// DB 입력하기
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





























