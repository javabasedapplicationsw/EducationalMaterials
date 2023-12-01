package kr.co.himedia.openapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/naverSearchAPI.do")
public class OpenSearchAPI extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인증 정보 설정
		String clientId = "jHW_zQG0GfbhLxEbKob_";				//본인의 클라이언트 아이디
		String clientSecret = "RtuWKVnOPK";						//본인의 클라이언트 시크릿 
		
		//2. 검색 조건 설정
		int startNum = 0;										//검색 시작 위치		=> 매개변수로 받음
		String text = null;										//검색어 				=> 매개변수로 받음
		
		try {
			startNum = Integer.parseInt(request.getParameter("startNum")) ;		//시작위치 정수로 변경
			String searchText = request.getParameter("keyword");
			text = URLEncoder.encode(searchText, "UTF-8");						//검색어는 한글 깨짐 방지하기 위해 UTF-8으로 인코딩함 			
		} catch (UnsupportedEncodingException e) {
			System.out.println("검색어 인코딩 실패");
			throw new RuntimeException("검색어 인코딩 실패", e);
		}
		
		//3. API URL 조합
		String apiURL = "https://openapi.naver.com/v1/search/blog?query="+text+"&display=10&start="+startNum;	//json 결과 
		
		//4. API 호출 
		//클라이언트 아이디와 시크릿을 요청 헤더로 전달해 API 호출
		Map<String, String> reqeustHeaders = new HashMap<>();
		reqeustHeaders.put("X-Naver-Client-Id", clientId);
		reqeustHeaders.put("X-Naver-Client-Secret", clientSecret);
		
		String responseBody = get(apiURL, reqeustHeaders);
		
		//5. 결과 출력
		System.out.println(responseBody);
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(responseBody);
	}
	
    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }	
}
























