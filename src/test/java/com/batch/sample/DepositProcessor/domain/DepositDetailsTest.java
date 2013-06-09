package com.batch.sample.DepositProcessor.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.Test;

import junit.framework.TestCase;

public class DepositDetailsTest extends TestCase {

	DepositDetails depositDetails = new DepositDetails();
	

	@Test
	public void testId() {
		depositDetails.setId(55);
		TestCase.assertEquals(depositDetails.getId(), 55);
		TestCase.assertNotSame(depositDetails.getId(), 10);
	}

	@Test
	public void testAccountId() {
		depositDetails.setAccountId(55);
		TestCase.assertEquals(depositDetails.getAccountId(), 55);
		TestCase.assertNotSame(depositDetails.getAccountId(), 10);
	}

	@Test
	public void testDepositAmount() {
		BigDecimal amount = new BigDecimal(52.25);
		depositDetails.setDepositAmount(amount);
		TestCase.assertEquals(depositDetails.getDepositAmount(), amount);
		TestCase.assertNotSame(depositDetails.getDepositAmount(), new BigDecimal(10.30));
	}

	@Test
	public void testTimestamp() {
		Timestamp stamp = new Timestamp(1111111);
		Timestamp wrongStamp = new Timestamp(1111112);
		depositDetails.setTimestamp(stamp);
		TestCase.assertEquals(depositDetails.getTimestamp(), stamp);
		TestCase.assertNotSame(depositDetails.getTimestamp(), wrongStamp);
	}

	@Test
	public void testToString() {
		depositDetails.setAccountId(555);
		depositDetails.setDepositAmount(new BigDecimal(52.50));
		String message = "Account:" + depositDetails.getAccountId() + " Deposit Amount:" + depositDetails.getDepositAmount();
		assertEquals(depositDetails.toString(), message);
	}
	
}
