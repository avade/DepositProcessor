package com.batch.sample.DepositProcessor.exception;

public class DepositProcessingException extends Exception{

	private static final long serialVersionUID = 0001;

	public DepositProcessingException(String exception){
		super(exception);
	}
	
}
