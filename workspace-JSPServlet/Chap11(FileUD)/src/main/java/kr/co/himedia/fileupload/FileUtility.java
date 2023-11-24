package kr.co.himedia.fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtility {

	//파일 업로드 
	public static String uploadFile(HttpServletRequest request, String sdirectory) 
			throws IOException, ServletException {
		/*
		 * 		Part 객체 생성 및 파일 저장 
		 * 			새로운 파일명 생성("업로드일시.확장자")
		 * 			파일명 변경
		 * 			DAO를 통해 DB에 반영
		 * 			파일 목록 JSP로 리다이렉트 
		 */
		// Part 객체를 통해 서버로 전송된 파일명 읽어오기
		Part part = request.getPart("ofile");   // file타입으로 전송된 폼값을 받아 Part 객체에 저장함
		String partHeader = part.getHeader("content-disposition");	// Part 객체에서 Content-Disposition라는 헤더값 읽어옴
		System.out.println("partHeader = " + partHeader);		// partHeader = form-data; name="ofile"; filename="puppy.jpg"
																//                         <input>의 name속성값,     원본파일명 
		String[] phArr = partHeader.split("filename=");		// 헤더의 내용에서 파일명을 추출하기 위함. 헤데값에서 파일명 잘라내기 
		String originalFileName = phArr[1].trim().replace("\"", "");		// 더블쿼테이션을 제거함 
		
		// 전송된 파일이 있다면 디렉토리에 저장
		if (!originalFileName.isEmpty()) {
			part.write(sdirectory + File.separator + originalFileName);
		}
		
		// 원본 파일명 반환
		return originalFileName;
	}

	// 파일명 변경
	public static String renameFile(String sDirectory, String fileName) {
		//원본파일의 확장자 잘라내기
		String ext = fileName.substring(fileName.lastIndexOf("."));
		
		//날짜 및 시간을 통해 파일명 생성
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		
		//날짜_시간.확장자 형태의 새로운 파일명 생성
		String newFileName = now + ext;
		
		//기존 파일명 => 새로운 파일명 변경
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		// 변경된 파일명 반환
		return newFileName;
	}
}





















