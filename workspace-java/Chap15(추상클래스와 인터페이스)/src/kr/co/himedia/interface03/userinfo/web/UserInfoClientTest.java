package kr.co.himedia.interface03.userinfo.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import kr.co.himedia.interface03.userinfo.UserInfoDTO;
import kr.co.himedia.interface03.userinfo.dao.UserInfoDAO;
import kr.co.himedia.interface03.userinfo.dao.oracle.UserInfoOracleDAO;

public class UserInfoClientTest {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("db.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String dbtype = prop.getProperty("DBTYPE");
		
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setUserId("himedia");
		userInfoDTO.setUserwd("0304");
		userInfoDTO.setUserName("하이미디어");
		
		UserInfoDAO userInfoDAO = null;
		if(dbtype.equals("ORACLE")) {
			userInfoDAO = new UserInfoOracleDAO();
		}
		
		userInfoDAO.insertUserInfo(userInfoDTO);
		
		
	}

}







