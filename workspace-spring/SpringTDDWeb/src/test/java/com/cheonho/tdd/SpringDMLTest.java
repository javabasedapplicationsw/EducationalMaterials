package com.cheonho.tdd;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SpringDMLTest {
	@Autowired
	DataSource ds;
	
	@Test
	public void springJdbcConnTest() throws SQLException {
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
		assertTrue(conn != null);
	}
	
	@Test
	public void insertUserTest() throws SQLException {
		User user = new User("cheonHo3", "0305", "cheonHo3", "cheonHo3@gmail.com", new Date(), "fb", new Date());
		deleteAll();
		int rowCnt = insertUser(user);
		
		assertTrue(rowCnt==1);
	}

	//사용자 정보를 t_user 테이블에 저장하는 메서드
	/*
INSERT INTO T_USER VALUES(?, ?, ?, ?, ?, ?, sysdate)	 * 
	 */
	private int insertUser(User user) throws SQLException {
		Connection conn = ds.getConnection();
		// 입력값에 사용된 물음표를 인파라미터라고 함. -- 정확한 값을 나중에 채워주겠다는 의미임 
		String sql = "INSERT INTO T_USER VALUES(?, ?, ?, ?, ?, ?, sysdate)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 인파라미터 설정시 데이터 타입에 맞는 setter메서드를 사용함 -- setter메서드는 데이터 타입별로 준비되어 있음
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPwd());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(6, user.getSns());
		int rowCnt = pstmt.executeUpdate();					//insert, update, delete
		
		return rowCnt;
	}

	private void deleteAll() throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "DELETE FROM T_USER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}
}












