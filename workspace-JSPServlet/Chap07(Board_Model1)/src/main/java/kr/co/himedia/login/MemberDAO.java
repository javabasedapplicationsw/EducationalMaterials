package kr.co.himedia.login;

import java.sql.SQLException;

import kr.co.himedia.common.JDBConnection;

public class MemberDAO extends JDBConnection {

	public MemberDAO(String driver, String url, String id, String pwd) {
		super(driver, url, id, pwd);
	}
	
	// 입력한 아이디/패스워드와 일치하는 회원 정보를 체크
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND PASS = ?";
		
		try {
			psmt = con.prepareStatement(query);		// 동적 쿼리문 준비
			psmt.setString(1, uid);					// 쿼리문의 첫 번째 인파라미터에 값 설정
			psmt.setString(2, upass);				// 쿼리문의 두 번째 인파라미터에 값 설정
			rs = psmt.executeQuery();				// 쿼리문 실행
			
			// 결과 확인
			if (rs.next()) {
				//쿼리 결과로 얻은 회원 정보(rs)를 DTO 객체에 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;			// DTO 객체 반환 
	}
}


















