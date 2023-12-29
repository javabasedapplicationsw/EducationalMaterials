package com.cheonho.vision;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoImplTest {
	@Autowired
	UserDao userDao;
	
	@Test
	public void updateUser() throws SQLException {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2023, 12, 29);
		
		userDao.deleteAll();
		User user = 
			new User("cheonHo", "0305", "cheonHo", "cheonHo@gmail.com", new Date(cal.getTimeInMillis()), "fb", new Date());
		int rowCnt = userDao.insertUser(user);
		assertTrue(rowCnt == 1);
		
		user.setPwd("0306");
		user.setEmail("cheonHo2@gmail.com");
		rowCnt = userDao.updateUser(user);
		assertTrue(rowCnt == 1);
		
		User user2 = userDao.selectUser(user.getId());
		System.out.println("user = " + user);
		System.out.println("user2 = " + user2);
		assertTrue(user.equals(user2));
	}
	
}



















