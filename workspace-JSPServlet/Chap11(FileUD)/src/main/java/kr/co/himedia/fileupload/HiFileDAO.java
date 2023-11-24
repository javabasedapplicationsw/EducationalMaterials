package kr.co.himedia.fileupload;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
INSERT INTO HIFILE (ID, TITLE, CATEGORY, OFILE, SFILE)
VALUES(seq_board_num.nextval, '?', '?', '?', '?');
 */
public class HiFileDAO extends DBConnPool {

	// 입력
	public int insertFile(HiFileDTO dto) {
		int result = 0;
		
		String query = "INSERT INTO HIFILE (ID, TITLE, CATEGORY, OFILE, SFILE) "
						+ " VALUES(seq_board_num.nextval, ?, ?, ?, ?) ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getCategory());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Insert 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<HiFileDTO> hiFileList() {
		List<HiFileDTO> fileList = new ArrayList<>();
		
		String query = "SELECT * FROM HIFILE ORDER BY id DESC";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				HiFileDTO dto = new HiFileDTO();
				dto.setId(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setCategory(rs.getString(3));
				dto.setOfile(rs.getString(4));
				dto.setSfile(rs.getString(5));
				dto.setPostdate(rs.getString(6));
				
				fileList.add(dto);
			}
			
			
		} catch (SQLException e) {
			System.out.println("SELECT 시 에외 발생");
			e.printStackTrace();
		}
		
		
		return fileList;
	}
	
}

















