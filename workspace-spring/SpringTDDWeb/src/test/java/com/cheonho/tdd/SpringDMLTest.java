package com.cheonho.tdd;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	//@Test
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
	public int insertUser(User user) throws SQLException {
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

	public void deleteAll() throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "DELETE FROM T_USER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}
	
	//@Test
	public void selectUserTest() throws SQLException {
		deleteAll();
		User user = new User("cheonHo", "0305", "cheonHo", "cheonHo@gmail.com", new Date(), "fb", new Date());
		int rowCnt = insertUser(user);
		User user2 = selectUser("cheonHo");
		
		assertTrue(user.getId().equals("cheonHo"));
	}

	public User selectUser(String id) throws SQLException {
		
		Connection conn = ds.getConnection();
		
		String sql = "SELECT * FROM t_user WHERE ID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			User user = new User();
			user.setId(rs.getString(1));
			user.setPwd(rs.getString(2));
			user.setName(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setBirth(new Date(rs.getDate(5).getTime()));
			user.setSns(rs.getString(6));
			user.setReg_date(new Date(rs.getTimestamp(7).getTime()));
			return user;
		}
		
		return null;
	}
	
	//@Test
	public void deleteUserTest() throws SQLException {
		deleteAll();
		int rowCnt = deleteUser("cheonho");
		assertTrue(rowCnt == 0);
		
		User user = new User("cheonHo", "0305", "cheonHo", "cheonHo@gmail.com", new Date(), "fb", new Date());
		rowCnt = insertUser(user);
		assertTrue(rowCnt == 1);
		
		rowCnt = deleteUser(user.getId());
		assertTrue(rowCnt == 1);
		
		assertTrue(selectUser(user.getId()) == null);
	}

	public int deleteUser(String id) throws SQLException {
		Connection conn = ds.getConnection();
		
		String sql = "DELETE FROM t_user WHERE id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
//		int rowCnt = pstmt.executeUpdate();
//		return rowCnt;
		return pstmt.executeUpdate();
	}
	
	@Test
	public void updateUserTest() throws SQLException {
		deleteAll();
		User user = new User("cheonHo", "0305", "cheonHo", "cheonHo@gmail.com", new Date(), "fb", new Date());
		int rowCnt = insertUser(user);
		assertTrue(rowCnt == 1);
		
		user.setPwd("0306");
		user.setName("cheonHo2");
		user.setEmail("cheonHo2@gmail.com");
		rowCnt = updateUser(user);
		assertTrue(rowCnt == 1);
		
	}
	
	public int updateUser(User user) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "UPDATE T_USER " +
					"SET PWD=?, NAME=?, EMAIL=?, BIRTH=?, SNS=?, REG_DATE=? " +
					"WHERE ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getPwd());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(5, user.getSns());
		pstmt.setDate(6, new java.sql.Date(user.getReg_date().getTime()));
		pstmt.setString(7, user.getId());
		
		int rowCnt = pstmt.executeUpdate();
		return rowCnt;
	}
}












