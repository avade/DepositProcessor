package com.batch.sample.DepositProcessor.exception;

import org.junit.Test;

import junit.framework.TestCase;

public class ExceptionTest extends TestCase {

	@Test
	public void testDepositProcessingExceptionMessage(){
		String message = "this is an exception message";
		try{
			throw new DepositProcessingException(message);
		}catch(DepositProcessingException ex){
			TestCase.assertEquals(message, ex.getMessage());
		}
	}
}
