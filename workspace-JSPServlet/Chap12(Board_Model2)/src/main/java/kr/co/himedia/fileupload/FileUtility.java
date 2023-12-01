package kr.co.himedia.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import kr.co.himedia.utils.JSFunction;

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

	// multiple 속성 추가로 2개 이상의 파일 업로드
	public static ArrayList<String> multipleFile(HttpServletRequest request, String saveDirectory) throws IOException, ServletException {
		
		// 파일명 저장을 위한 컬렉션 생성
		ArrayList<String> listFileName = new ArrayList<>();
		
		//Part 객체를 통해 서버로 전송된 파일명 읽어오기
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			//파일일 아니라면 업로드의 대상이 아니므로 무시
			if (!part.getName().equals("ofile"))
				continue;
			
			// Part 객체의 해더값 중 content-disposition 읽어오기
			String partHeader = part.getHeader("content-disposition");
			System.out.println("partHeader = " + partHeader);
			/*
			partHeader = form-data; name="ofile"; filename="puppy (1).jpg"
			partHeader = form-data; name="ofile"; filename="cat (1).png"
			partHeader = form-data; name="ofile"; filename="cat.png" 
		    */			
			
			//헤더 값에서 파일명 잘라내기
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().replace("\"", "");
			
			if (!originalFileName.isEmpty())
				part.write(saveDirectory +File.separator+ originalFileName);
			
			// 컬렉션에 추가
			listFileName.add(originalFileName);
		}
		
		// 원본 파일명 반환
		return listFileName;
		
	}

	// 첨부된 파일을 찾아 다운로드 함
	public static void download(HttpServletRequest request, HttpServletResponse response, String directory, String sfileName,
			String ofileName) {
		
		String sDirectory =  request.getServletContext().getRealPath(directory);	
		try {
			// 파일을 찾아 입력 스트림 생성
			File file = new File(sDirectory, sfileName);
			InputStream inStream = new FileInputStream(file);
			
			// 한글 파일명 깨짐 방지
			/* 
			 	WOW64 (Windows on Windows 64-bit) 
			 		- 64비트 버전의 윈도우에서 32비트 응용프로그램을 실행할 수 있다는 의미
			 		- 인터텟 익스플로러는 현재 과거에 비해 사용 빈도 낮아짐. 허지만 국내 아직 사용되고 있으므로 이에 처리도 해주는 좋음 
			*/
			String client = request.getHeader("User-Agent");
			
			if (client.indexOf("WOW64") == -1) {			// 웹브라우저가 인터넷 익스플로러가 아닌 경우 
				ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");	//getBytes("UTF-8")로 원본 파일명을 바이트 배열로 변환 후, 
			} else {																				//ISO-8859-1 캐릭터 셋의 문자열로 재생성함
				ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");  // 익스인 경우 getBytes("KSC5601")을 이용하여 바이트 배열로 변환 후,
			}																						//ISO-8859-1 캐릭터 셋의 문자열을 재성성함	
			
			// 파일 다운로드용 응답 헤더 설정
			response.reset();			//응답 헤더를 초기화
			response.setContentType("application/octet-stream");	// 파일 다운로드 창을 띄우기 위한 콘텐츠 타입을 지정함 (8비트 단위의 바이너리 데이터를 의미)
																	// 응답 헤더로 설정하게 되면 파일의 종류 상관없이 웹 브라저는 다운로드 창을 띄우게 됨
			response.setHeader("Content-Disposition", "attachment; filename=\""+ofileName+"\"");		
			
			response.setHeader("Content-Length", "" + file.length());
			
			// 출력 스트림 초기화
			//out.clear();
			// response 내장 객체로부터 새로운 출력 스트림 생성
			OutputStream outputStream = response.getOutputStream();
			
			// 출력 스트림에 파일 내용 출력
			byte[] b = new byte[(int)file.length()];
			int readBuffer = 0;
			while((readBuffer = inStream.read(b)) > 0) {
				outputStream.write(b, 0, readBuffer);
			}
			
			// 입/출력 스트림 닫기
			inStream.close();
			outputStream.close();		
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
			e.printStackTrace();			
		}				
	}

	// 파일 삭제
	public static void deleteFile(HttpServletRequest request, String directory, String fileName) {
		String sdirectory = request.getServletContext().getRealPath(directory);
		File file = new File(sdirectory +File.separator+ fileName);
		if (file.exists())
			file.delete();
	}
}





















