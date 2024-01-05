package com.cheonho.tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class TransactionTest {

	@Autowired
	DataSource ds;
	
	@Test
	public void transactionTest() throws SQLException {
		Connection conn = null;
		
		try {
			deleteAll();
			conn = ds.getConnection();
			//기본값은 conn.setAutoCommit(true);
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO T_USER VALUES(?, ?, ?, ?, ?, ?, sysdate)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "cheonho");
			pstmt.setString(2, "0305");
			pstmt.setString(3, "cheonho");
			pstmt.setString(4, "cheonho@gmail.com");
			pstmt.setDate(5, new java.sql.Date(new Date().getTime()));
			pstmt.setString(6, "fb");
			
			int rowCnt = pstmt.executeUpdate();
			
			pstmt.setString(1, "cheonho");
			rowCnt = pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}
	
	public void deleteAll() throws SQLException {
		Connection conn = ds.getConnection();
		
		String sql = "delete from t_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}	
}
