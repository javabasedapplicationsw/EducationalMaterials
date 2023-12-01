package kr.co.himedia.mvcboard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.himedia.common.DBConnPool;

public class MvcBoardDAO extends DBConnPool {			// 커넥션 풀 상속

	public MvcBoardDAO() {
		super();
	}
	
	// (검색 조건에 맞는) 게시물의 개수 반환 
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		//쿼리문 준비
		String query = "SELECT COUNT(*) FROM mvcboard";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " " 
					+ " LIKE '%" + map.get("searchWord") + "%'";
		}
				
		try {
			stmt = con.createStatement();				//쿼리문 생성
			rs = stmt.executeQuery(query);				//쿼리문 실행
			
			rs.next();
			totalCount = rs.getInt(1);					//검색된 게시물 개수 저장
		} catch (SQLException e) {
			System.out.println("게시물 카운트 중 예외 발생");
			e.printStackTrace();
		}
				
		return totalCount;								// 게시물 개수를 서블릿으로 반환
	}
	
	// (검색 조건에 맞는) 게시물 목록 반환 (페이징 기능 지원)
	public List<MvcBoardDTO> selectListPage(Map<String, Object> map) {
		List<MvcBoardDTO> board = new ArrayList<>();
		
		//쿼리문 준비
		String query = " SELECT * FROM ( "
				+ " 	SELECT A.*, rownum rNum FROM ( "
				+ " 		SELECT * FROM mvcboard ";
		// 검색 조건이 있다면 where절로 추가 
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " " 
					+ " LIKE '%" + map.get("searchWord") + "%'";
		}
		query += " ORDER BY id desc"
			   + " 	) A "
			   + " ) "
			   + " WHERE rNum BETWEEN ? AND ?"			//게시물 구간은 인파라미터로.
			   ;			
		
		try {
			psmt = con.prepareStatement(query);			//동적 쿼리문 생성
			psmt.setString(1, map.get("start").toString()); //인파라미터 설정
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();					//쿼리문 실행
			
			//반환된 게시물 목록을 List 컬렉션에 추가
			while(rs.next()) {
				MvcBoardDTO dto = new MvcBoardDTO();
				
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
				
				board.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return board;				// 목록 반환 
	}

	// 게시글 데이터를 받아 DB에 추가 (파일 업로드 지원)
	public int insertWrite(MvcBoardDTO dto) {
		int result = 0;
		
		String query = "INSERT INTO MVCBOARD (ID, NAME, TITLE, CONTENT,OFILE ,SFILE, PASS) "
					+" VALUES(seq_board_num.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getPass());
			result = psmt.executeUpdate();			
			
		} catch (SQLException e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 주어진 일련번호(id)에 해당하는 게시물을 DTO에 담아 반환
	public MvcBoardDTO selectView(String id) {
		MvcBoardDTO dto = new MvcBoardDTO();
		String query = "SELECT * FROM MVCBOARD WHERE id=?";			// 쿼리문 템플릿 준비
		
		try {
			psmt = con.prepareStatement(query);						// 쿼리문 준비 
			psmt.setString(1, id); 									// 인파라미터 설정
			rs = psmt.executeQuery();								// 쿼리문 실행
			
			if (rs.next()) {
				// 결과를 DTO 객체에 저장
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
			}
			
		} catch (SQLException e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return dto;				// 결과 반환 
	}

	// 주어진 일련번호(id)에 해당하는 게시물의 조회수 1 증가시킴
	public void updateVisitCount(String id) {
		String query = "UPDATE MVCBOARD SET VISITCOUNT = VISITCOUNT + 1 WHERE id = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	// 다운로드 횟수 1 증가시킴
	public void downloadCount(String id) {
		String sql = "UPDATE MVCBOARD SET DOWNCOUNT = DOWNCOUNT + 1 WHERE ID = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("다운로드 횟수 증가 중 오류 발생");
			e.printStackTrace();
		}
	}
	
	// 입력한 비밀번호가 선택된 게시물의 비밀번호와 일치하는지 확인
	public boolean confirmPassword(String pass, String id) {
		boolean result = true;
		
		String sql = "SELECT count(*) FROM MVCBOARD WHERE pass = ? AND ID = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, pass);
			psmt.setString(2, id);
			rs = psmt.executeQuery();
			
			rs.next();
			if (rs.getInt(1) == 0)
				result = false;
			
		} catch (SQLException e) {
			System.out.println("비밀번호와 일치 체크 중 오류 발생");
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	// 선택된 게시물 삭제하기 
	public int deleteBoard(String id) {
		int result = 0;
		String query = "DELETE FROM MVCBOARD WHERE ID = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
				
		return result;
	}

	// 게시글 데이터를 받아 DB에 저장되어 있던 내용을 업데이트하기 (파일 업로드 지원)
	public int updateBoard(MvcBoardDTO dto) {
		int result = 0;
		
		// 쿼리문 템플릿 준비
		String query = "UPDATE MVCBOARD SET TITLE=?, NAME=?, CONTENT=?, OFILE=?, SFILE=? "
						+ " WHERE ID=? AND PASS =?";
		
		// 쿼리문 준비
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getId());
			psmt.setString(7, dto.getPass());
			
			//쿼리문 실행
			result = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
		
	}
}



































