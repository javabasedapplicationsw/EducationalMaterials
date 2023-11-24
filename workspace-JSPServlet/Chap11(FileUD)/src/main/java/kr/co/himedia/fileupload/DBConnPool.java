package kr.co.himedia.fileupload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnPool {
	public Connection con;		// 데이터베이스와 연결 담당
	public Statement stmt;		// 인파라미터가 없는 정적 쿼리문 실행할 때 사용
	public PreparedStatement psmt;		// 인파라미터가 있는 동적 쿼리문을 실행 할 때 사용
	public ResultSet rs;				// SELECT 쿼리문의 결과를 저장할 때 사용
	
	public DBConnPool() {
		
		try {
			// 커넥션 풀(DataSource) 얻기
			Context initCtx = new InitialContext();		// 네이밍 서비스(JNDI)에서 이름과 실체 객체를 연결해주는 개념이 Context임
			Context ctx = (Context)initCtx.lookup("java:comp/env");	  // "java:comp/env"는 현재 웹 애플리케이션의 루트 디렉토리임
			DataSource source = (DataSource)ctx.lookup("himedia_myoracle");		// "java:comp/env" 아래에 위치한 "himedia_myoracle" 자원(데이터소스, 커넥션 풀)을 얻어옴
			
			// 커넥션 풀을 통해 연결 얻기
			con = source.getConnection();		// 데이터소스를 통해 풀에 생성되어 있는 연결 객체를 얻어옴 
			
			System.out.println("DB 컨넥션 풀 연결 성공");
			
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
				if (con != null) con.close();		//  자동으로 커넥션 풀로 반납됨
				
				System.out.println("DB 컨넥션 풀 자원 반납");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}	
}








