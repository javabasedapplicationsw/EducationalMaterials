<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String saveDirectory = application.getRealPath("/Uploads");
	String saveFileName = request.getParameter("sName");
	String originalFileName = request.getParameter("oName");
	
	// 입력 스트림 생성
	File file = new File(saveDirectory, saveFileName);
	InputStream inStream = new FileInputStream(file);
	
	// 한글 파일명 깨짐 방지
	/* 
	 	WOW64 (Windows on Windows 64-bit) 
	 		- 64비트 버전의 윈도우에서 32비트 응용프로그램을 실행할 수 있다는 의미
	 		- 인터텟 익스플로러는 현재 과거에 비해 사용 빈도 낮아짐. 허지만 국내 아직 사용되고 있으므로 이에 처리도 해주는 좋음 
	*/
	String client = request.getHeader("User-Agent");
	
	if (client.indexOf("WOW64") == -1) {			// 웹브라우저가 인터넷 익스플로러가 아닌 경우 
		originalFileName = new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1");	//getBytes("UTF-8")로 원본 파일명을 바이트 배열로 변환 후, 
	} else {																				//ISO-8859-1 캐릭터 셋의 문자열로 재생성함
		originalFileName = new String(originalFileName.getBytes("KSC5601"), "ISO-8859-1");  // 익스인 경우 getBytes("KSC5601")을 이용하여 바이트 배열로 변환 후,
	}																						//ISO-8859-1 캐릭터 셋의 문자열을 재성성함	
	
	// 파일 다운로드용 응답 헤더 설정
	response.reset();			//응답 헤더를 초기화
	response.setContentType("application/octet-stream");	// 파일 다운로드 창을 띄우기 위한 콘텐츠 타입을 지정함 (8비트 단위의 바이너리 데이터를 의미)
															// 응답 헤더로 설정하게 되면 파일의 종류 상관없이 웹 브라저는 다운로드 창을 띄우게 됨
	response.setHeader("Content-Disposition", "attachment; filename=\""+originalFileName+"\"");		
	
	
	
	

%>
















