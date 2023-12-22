package com.cheonho.winter;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DBConnectionTest03 {

	public static void main(String[] args) throws SQLException {
		ApplicationContext ac = 
				new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
		DataSource ds = ac.getBean(DataSource.class);
		
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
	}
}
