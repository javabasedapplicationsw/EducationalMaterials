package kr.co.himedia.interface03.userinfo.dao;

import kr.co.himedia.interface03.userinfo.UserInfoDTO;

public interface UserInfoDAO {
	
	void insertUserInfo(UserInfoDTO userInfoDTO);
	void updateUserInfo(UserInfoDTO userInfoDTO);
	void deleteUserInfo(UserInfoDTO userInfoDTO);
	void selectUserInfo(UserInfoDTO userInfoDTO);
}
