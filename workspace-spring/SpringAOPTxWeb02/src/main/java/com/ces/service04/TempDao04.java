package com.ces.service04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class TempDao04 {

	@Autowired
	DataSource ds;
	
	public int insert(int key, int value) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//conn = ds.getConnection();
			conn = DataSourceUtils.getConnection(ds);
			System.out.println("conn = " + conn);
			pstmt = conn.prepareStatement("insert into temp values(?,?)");
			pstmt.setInt(1, key);
			pstmt.setInt(2, value);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(pstmt);
			DataSourceUtils.releaseConnection(conn, ds);
		}
		
	}
	
	private void close(AutoCloseable...closeables) {
		for (AutoCloseable autoCloseable : closeables) {
			if (autoCloseable != null)
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
	}	
	
	public void deleteAll() throws Exception {
		Connection conn = ds.getConnection();				//Tx과 별개로 동작해야하므로 이렇게 conn 객체를 얻어야 함 
		
		String sql = "delete from temp";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		close(pstmt);
	}
}























