package com.batch.sample.DepositProcessor;

import java.math.BigDecimal;

import com.batch.sample.DepositProcessor.domain.DepositDetails;
import com.batch.sample.DepositProcessor.persistance.DAO.DepositDetailsDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class DatabaseIT extends TestCase {

	@Autowired
    DepositDetailsDAO depositDetailsDAO;
	
	@Test
	@Transactional
	public void testDBSaveAndFind(){
		DepositDetails depositDetails = new DepositDetails();
		depositDetails.setAccountId(11);
		depositDetails.setDepositAmount(new BigDecimal(20.20));
		
		depositDetailsDAO.save(depositDetails);
		DepositDetails result = (DepositDetails) depositDetailsDAO.findOne(depositDetails.getId());
		
		TestCase.assertEquals(result.getAccountId(), depositDetails.getAccountId());
		TestCase.assertEquals(result.getDepositAmount(), depositDetails.getDepositAmount());
		
	}
	
	public void testDBDelete(){
		DepositDetails depositDetails = new DepositDetails();
		depositDetails.setAccountId(11);
		depositDetails.setDepositAmount(new BigDecimal(20.20));
		
		depositDetailsDAO.save(depositDetails);
		TestCase.assertNotNull(depositDetailsDAO.findOne(depositDetails.getId()));
		depositDetailsDAO.delete(depositDetails);
		TestCase.assertNull(depositDetailsDAO.findOne(depositDetails.getId()));
	}
	
}
