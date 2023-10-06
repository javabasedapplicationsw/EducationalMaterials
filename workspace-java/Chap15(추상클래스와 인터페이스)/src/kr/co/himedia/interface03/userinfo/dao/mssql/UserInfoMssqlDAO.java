package kr.co.himedia.interface03.userinfo.dao.mssql;

import kr.co.himedia.interface03.userinfo.UserInfoDTO;
import kr.co.himedia.interface03.userinfo.dao.UserInfoDAO;

public class UserInfoMssqlDAO implements UserInfoDAO {

	@Override
	public void insertUserInfo(UserInfoDTO userInfoDTO) {
		System.out.println("insert into MSSQL DB userid= " + userInfoDTO.getUserId());	
	}

	@Override
	public void updateUserInfo(UserInfoDTO userInfoDTO) {
		System.out.println("update MSSQL DB userid= " + userInfoDTO.getUserId());
		
	}

	@Override
	public void deleteUserInfo(UserInfoDTO userInfoDTO) {
		System.out.println("delete MSSQL DB userid= " + userInfoDTO.getUserId());
		
	}

	@Override
	public void selectUserInfo(UserInfoDTO userInfoDTO) {
		System.out.println("select MSSQL DB userid= " + userInfoDTO.getUserId());
		
	}

}
