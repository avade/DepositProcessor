package com.batch.sample.DepositProcessor.service;

/**
 * @author alex.d.ley
 * A simple interface that specifies the operations required of any service
 * that processes data within the application.
 */
public interface DepositProcessService {
	
	public void processStringSubmission(String data);
}
