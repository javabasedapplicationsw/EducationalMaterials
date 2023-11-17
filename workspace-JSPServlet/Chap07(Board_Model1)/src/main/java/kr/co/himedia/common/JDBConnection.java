package kr.co.himedia.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContext;

public class JDBConnection {

	public Connection con;		// 데이터베이스와 연결 담당
	public Statement stmt;		// 인파라미터가 없는 정적 쿼리문 실행할 때 사용
	public PreparedStatement psmt;		// 인파라미터가 있는 동적 쿼리문을 실행 할 때 사용
	public ResultSet rs;				// SELECT 쿼리문의 결과를 저장할 때 사용
	
	public JDBConnection() {
		
		try {
			// JDBC 드라이버 로드 
			Class.forName("oracle.jdbc.OracleDriver");		// JDBC 드라이버를 메모리에 로드함 (new 키워드 대신 클래스명을 통해 직접 객체 생성)
			
			// DB에 연결
			//             오라클 프로토콜     호스트명(IP) port sid
			//            ----------------  --------- ---- ---
			String url = "jdbc:oracle:thin:@localhost:1521/XE";
			String id = "hm";
			String pwd = "0305";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공 (기본 생성자)");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JDBConnection(String driver, String url, String id, String pwd) {
		
		try {
			// JDBC 드라이버 로드 
			Class.forName(driver);
			
			// DB에 연결
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공 (오버로드된 생성자)");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JDBConnection(ServletContext application) {
		

		try {
			// JDBC 드라이버 로드 
			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);
			
			// DB에 연결
			String url = application.getInitParameter("OracleURL");
			String id = application.getInitParameter("OracleId");
			String pwd = application.getInitParameter("OraclePwd");
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공 (오버로드된 생성자2)");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 연결 해제(자원 반납)
	public void close() {
		
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (psmt != null) psmt.close();
				if (con != null) con.close();
				
				System.out.println("JDBC 자원 해제");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
}










