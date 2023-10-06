package kr.co.himedia.interface03.userinfo.dao.mysql;

import kr.co.himedia.interface03.userinfo.UserInfoDTO;
import kr.co.himedia.interface03.userinfo.dao.UserInfoDAO;

public class UserInfoMysqlDAO implements UserInfoDAO {

	@Override
	public void insertUserInfo(UserInfoDTO userInfoDTO) {
		System.out.println("insert into Mysql DB userid= " + userInfoDTO.getUserId());	
		
	}

	@Override
	public void updateUserInfo(UserInfoDTO userInfoDTO) {
		System.out.println("update Mysql DB userid= " + userInfoDTO.getUserId());
		
	}

	@Override
	public void deleteUserInfo(UserInfoDTO userInfoDTO) {
		System.out.println("delete Mysql DB userid= " + userInfoDTO.getUserId());	
		
	}

	@Override
	public void selectUserInfo(UserInfoDTO userInfoDTO) {
		System.out.println("select Mysql DB userid= " + userInfoDTO.getUserId());
		
	}

}
