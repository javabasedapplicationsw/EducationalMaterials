package shop.interhouse.orm.repository;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import shop.interhouse.orm.domain.User;


public interface UserDao {

	public User selectUser(String id);
	public void deleteAll() throws SQLException;
	public int insertUser(User user);		// 사용자 정보를 t_user 테이블에 저장하는 메서드 
	public int updateUser(User user);		// 매개변수로 받은 사용자 정보로 t_user 테이블을 update하는 메서드 
	public int deleteUser(String id);
}
