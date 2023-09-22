package kr.co.himedia.constructor02;

public class UserInfoTest {

	public static void main(String[] args) {
		
		UserInfo userInfo0 = new UserInfo();
		userInfo0.userId = "hello";
		userInfo0.userPassWord = "0303";
		userInfo0.userName = "Shin sa";
		System.out.println(userInfo0.showUserInfo());
		
		System.out.println();
		
		UserInfo userInfo = new UserInfo("himedia", "0308", "Admiral Lee");
		System.out.println(userInfo.showUserInfo());
	}
}
