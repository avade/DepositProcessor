package com.batch.sample.DepositProcessor.service;

import com.batch.sample.DepositProcessor.domain.DepositDetails;
import com.batch.sample.DepositProcessor.persistance.DAO.DepositDetailsDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;  
import static org.mockito.Mockito.*;  

import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class DepositDetailsToDBServiceTest extends TestCase {
	
	@Mock
    DepositDetailsDAO depositDAOmock;
	
	DepositDetails depositDetails;
	
	@Test
	public void testSave() {
		DepositDetailsToDBService depositDetailsToDBService = new DepositDetailsToDBService();
		depositDetailsToDBService.setDepositDetailsDAO(depositDAOmock);
		depositDetailsToDBService.save(depositDetails);
		verify(depositDAOmock, times(1)).save(depositDetails);
		verify(depositDAOmock, times(0)).delete(depositDetails);
	}
	

}
