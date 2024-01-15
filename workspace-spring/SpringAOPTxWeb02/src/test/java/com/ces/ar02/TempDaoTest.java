package com.ces.ar02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ces.service.TempDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class TempDaoTest {

	@Autowired
	TempDao tempDao;
	
	@Test
	public void insertTest() throws Exception {
		tempDao.insert(1, 100);   //성공
		tempDao.insert(1, 200);	  //실패 	
	}
}


















