package com.batch.sample.DepositProcessor.helper;

import java.math.BigDecimal;

import com.batch.sample.DepositProcessor.domain.DepositDetails;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class JSONtoDepositDetailsGSONConverterTest extends TestCase{
	
	DepositDetails depositDetails;
	
	JSONtoDepositDetailsConverter depositDetailsConverter;
	
	private final String validJsonString = "{\"accountId\":\"555\",\"depositamount\":\"255.45\"}";
	private final String invalidJsonString = "{\"accountId\":\"41994\",\"dpositamount\":\"23.54aaaa\"}";
	
	
	
	@Before
	public void setUp() throws Exception{
		depositDetails = new DepositDetails();
		depositDetailsConverter = new JSONtoDepositDetailsGSONConverter();
		depositDetails.setAccountId(555);
		depositDetails.setDepositAmount(new BigDecimal(255.45));
		super.setUp();
	}
	
	@Test
	public void testConvertValidJSONStringtoDepositDetails() {
		DepositDetails result = depositDetailsConverter.convertJSONStringtoDepositDetails(validJsonString);
		TestCase.assertEquals(depositDetails.getAccountId(), result.getAccountId());
		TestCase.assertEquals(depositDetails.getDepositAmount(), result.getDepositAmount());
	}
	
	@Test
	public void testConvertInvalidJSONStringtoDepositDetails() {
		try{
			depositDetailsConverter.convertJSONStringtoDepositDetails(invalidJsonString);
		}catch (Exception e) {
			TestCase.assertTrue(true);
		}
	}

}
