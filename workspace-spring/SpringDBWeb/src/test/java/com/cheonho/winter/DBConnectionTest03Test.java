package com.cheonho.winter;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DBConnectionTest03Test {

	@Test
	public void springJDBCConnTest() throws SQLException {
		ApplicationContext ac = 
				new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
		DataSource ds = ac.getBean(DataSource.class);
		
		Connection conn = ds.getConnection();
		
		//괄호안의 조건식이 true면 테스트 성공, 아니면 실패
		assertTrue(conn != null);
	}
}




















