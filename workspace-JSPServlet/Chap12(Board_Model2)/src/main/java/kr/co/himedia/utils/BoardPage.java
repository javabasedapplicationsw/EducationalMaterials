package kr.co.himedia.utils;

public class BoardPage {

	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		// 3 단계 : 전체 페이지 수 계산 
		int totalPages = (int)(Math.ceil((double)totalCount / pageSize));
		
		// 4 단계 : '이전 페이지 블록 바로가기'
		int pageTemp = ((pageNum-1)/blockPage)*blockPage + 1;
		if (pageTemp != 1) {								// pageTemp가 1 아닐 때만 [첫 페이지]와 [이전 블록] 링크를 출력함 
			pagingStr += "<a href='"+reqUrl+"?pageNum=1'>[첫 페이지]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='"+reqUrl+"?pageNum="+(pageTemp-1)+"'>[이전 블록]</a>";
		}
			
		// 5 단계 : 각 페이지 번호 출력
		int blockCount = 1;
		while(blockCount <= blockPage && pageTemp <= totalPages) {
			if (pageTemp == pageNum)
				pagingStr += "&nbsp;" +pageTemp+ "&nbsp;";				//현재 페이지는 링크를 걸지 않음
			else 
				pagingStr += "&nbsp;<a href=' "+reqUrl+"?pageNum="+pageTemp+"'>" +pageTemp+"</a>&nbsp;";
			
			pageTemp++;
			blockCount++;		
		}
		
		// 6 단계 : 다음 페이지 블록 바로가기 출력
		if (pageTemp <= totalPages) {
			pagingStr += "<a href='"+reqUrl+"?pageNum="+pageTemp+" '>[다음 블록]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='"+reqUrl+"?pageNum="+totalPages+" '>[마지막 페이지]</a>";
		}
		
		
		return pagingStr;
	}
}





















