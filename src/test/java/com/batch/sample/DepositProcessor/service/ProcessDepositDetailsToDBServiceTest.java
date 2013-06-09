package com.batch.sample.DepositProcessor.service;

import java.math.BigDecimal;

import com.batch.sample.DepositProcessor.domain.DepositDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;  
import static org.mockito.Mockito.*;  

import org.mockito.runners.MockitoJUnitRunner;

import com.batch.sample.DepositProcessor.helper.JSONtoDepositDetailsConverter;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class ProcessDepositDetailsToDBServiceTest extends TestCase {

	@Mock
    DepositDetailsService depositDetailsService;
	@Mock
    JSONtoDepositDetailsConverter jsonConverter;

	String json = "json";
	String jsonInvalid = "jsonoh";

	DepositDetails depositDetails;
	ProcessDepositDetailsToDBService processDepositDetailsToDBService;

	@Before
	public void setUp(){
		processDepositDetailsToDBService = new ProcessDepositDetailsToDBService();
		depositDetails = new DepositDetails();
		depositDetails.setAccountId(111);
		depositDetails.setDepositAmount(new BigDecimal(22.50));

		//inject the mocks
		//TODO inject the mocks via Spring?
		processDepositDetailsToDBService.setDepositDetailsService(depositDetailsService);
		processDepositDetailsToDBService.setJsonConverter(jsonConverter);

		//setup mocks for positive and negitive scenario. 
		when(jsonConverter.convertJSONStringtoDepositDetails(json)).thenReturn(depositDetails);
		//negitive scenario, invalid json should result in an exception
		when(jsonConverter.convertJSONStringtoDepositDetails(jsonInvalid)).thenThrow(new NumberFormatException());
	}


	/**
	 * Tests that the correct methods are called within the ProcessDepositDetailsToDBService
	 * class method processStringSubmission.
	 */
	@Test
	public void testProcessStringSubmission() {

		processDepositDetailsToDBService.processStringSubmission(json);
		//check the number of times the methods are called, should be one time
		verify(jsonConverter, times(1)).convertJSONStringtoDepositDetails(json);
		verify(depositDetailsService, times(1)).save(depositDetails);

		//try to process the invalid json, we expect an exception in this scenario
		//the class should handel the exception internally
		processDepositDetailsToDBService.processStringSubmission(jsonInvalid);

		//check that the save method was not called again and that the convertJSON was called twice in total
		verify(jsonConverter, times(1)).convertJSONStringtoDepositDetails(jsonInvalid);
		verify(depositDetailsService, times(1)).save(depositDetails);
	}

}
