package com.ces.ar06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ces.service06.TxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class TxServiceTest {

	@Autowired
	TxService txService;
	
	//@Test
	public void insertTempWithoutTxTest() throws Exception {
		txService.insertTempWithoutTx();
	}
	
	//@Test
	public void insertTempWithTxFailTest() throws Exception {
		txService.insertTempWithTxFail();
	}	
	
	//@Test
	public void insertTempWithTxFail2Test() throws Exception {
		txService.insertTempWithTxFail2();
	}		
	
	//@Test
	public void insertTempWithTxFail3Test() throws Exception {
		txService.insertTempWithTxFail3();
	}	
	
	//@Test
	public void insertTempWithTxSuccessTest() throws Exception {
		txService.insertTempWithTxSuccess();
	}
	
	//@Test
	public void TxPropagationRequiredTest() throws Exception {
		txService.insertTempWithTxPropagation();
	}
	
	@Test
	public void TxPropagationRequired2Test() throws Exception {
		txService.insertTemp3WithTxPropagation();
	}
}















