package com.ces.service06;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ces.repository05.TempDao05;
import com.ces.repository05.TempDao06;

@Service
public class TxService {

	@Autowired TempDao05 tempDao05;
	@Autowired TempDao06 tempDao06;
	@Autowired DataSource ds;
	
	public void insertTempWithoutTx() throws Exception {
		tempDao05.insert(1, 100);
		tempDao05.insert(1, 200);
	}
	
	@Transactional(rollbackFor = Exception.class)			// Exception을 rollback
	public void insertTempWithTxFail() throws Exception {
		tempDao05.insert(1, 100);
		tempDao05.insert(1, 200);
	}	
	
	/*
	 * @Transactional		// RuntimeException, Error만 rollback함
	 */
	@Transactional
	public void insertTempWithTxFail2() throws Exception {
		tempDao05.insert(1, 100);		//성공
		throw new RuntimeException();
	}	
	
	@Transactional
	public void insertTempWithTxFail3() throws Exception {
		tempDao05.insert(1, 100);		//성공
		throw new Exception();			//이 경우는 rollback 처리 안됨 
	}	
	
	@Transactional
	public void insertTempWithTxSuccess() throws Exception {
		tempDao05.insert(1, 100);		//성공
		tempDao05.insert(2, 200);		//성공
	}	
	
	
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertTempWithTxPropagation() throws Exception {
		PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
		DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
		txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = tm.getTransaction(txd);
		
		try {
			tempDao05.insert(1, 100);		//성공
			insertTemp2WithTxPropagation();
			tempDao05.insert(2, 200);		//성공	
			tm.commit(status);
		} catch(Exception e) {
			e.printStackTrace();
			tm.rollback(status);
		}
		

	}
	
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertTemp2WithTxPropagation() throws Exception {
		PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
		DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
		txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = tm.getTransaction(txd);		
	
		try {
			tempDao06.insert(1, 100);		//성공
			tempDao06.insert(1, 100);		//실패		==> 실패하여 롤백
			tm.commit(status);
		} catch(Exception e) {
			e.printStackTrace();
			tm.rollback(status);
		}
		
	}	
	
	
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertTemp3WithTxPropagation() throws Exception {
		PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
		DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
		txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = tm.getTransaction(txd);
		
		try {
			tempDao05.insert(1, 100);		//성공
			insertTemp4WithTxPropagation();
			tempDao05.insert(1, 200);		//실패	==> 실패하여 롤백
			tm.commit(status);
		} catch(Exception e) {
			e.printStackTrace();
			tm.rollback(status);
		}
		

	}
	
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertTemp4WithTxPropagation() throws Exception {
		PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
		DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
		txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status = tm.getTransaction(txd);		
	
		try {
			tempDao06.insert(1, 100);		//성공
			tempDao06.insert(2, 100);		//성공		
			tm.commit(status);
		} catch(Exception e) {
			e.printStackTrace();
			tm.rollback(status);
		}
		
	}	
}




























