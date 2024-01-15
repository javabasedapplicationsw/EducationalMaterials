package com.ces.ar05;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ces.repository05.TempDao05;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class TempDaoTest {

	@Autowired
	TempDao05 tempDao;
	
	@Autowired DataSource ds;
	@Autowired PlatformTransactionManager tm;
	
	@Test
	public void insertTest() throws Exception {
		//TxManager 생성
		//PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
		//Tx 시작 
		TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
		
		try {
			tempDao.deleteAll();
			tempDao.insert(1, 100);   //성공	- 개별 connection	이지만 TxManager가 같은 connection을 사용하게 해줌  
			tempDao.insert(1, 200);	  //실패 	
			tm.commit(status); 		  //Tx 끝 - 성공하여 커밋	
		} catch(Exception ex) {
			tm.rollback(status); 	  //Tx 끝 - 실패하여 롤백 (같은 connection이 되어서 롤백이 됨) 	
		}
		

	}
}


















