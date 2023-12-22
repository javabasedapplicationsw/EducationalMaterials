package com.cheonho.winter;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

//Spring과 DB 연결하기 (Spring JDBC API 이용)
public class DBConnectionTest02 {

	public static void main(String[] args) throws SQLException {
		//데이터베이스 접속 정보 변수 선언
		String DB_URL = "jdbc:oracle:thin:@localhost:1521/XE";
		//DB 사용자 정보
		String DB_USER = "hm";
		String DB_PASSWORD = "0305";
		String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DB_DRIVER);
		ds.setUrl(DB_URL);
		ds.setUsername(DB_USER);
		ds.setPassword(DB_PASSWORD);
		
		//데이터베이스 연결 얻기
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
	}
}












