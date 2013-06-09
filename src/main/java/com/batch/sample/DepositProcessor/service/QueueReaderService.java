package com.batch.sample.DepositProcessor.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author alex.ley
 * A class used to read from a blocking queue and return the string value.
 * Implements the Spring Batch ItemReader interface allowing it to act
 * as a Spring Batch reader. 
 */
public class QueueReaderService implements ItemReader<String>{

	BlockingQueue<String> queue; 
	int timeoutSeconds;
	
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
				return getQueue().poll(getTimeoutSeconds(), TimeUnit.SECONDS);
	}
	
	public void setQueue(BlockingQueue<String> queue){
		this.queue = queue;
	}
	
	private BlockingQueue<String> getQueue(){
		return this.queue;
	}
	
	public void setTimeoutSeconds(int seconds){
		this.timeoutSeconds = seconds;
	}
	
	private int getTimeoutSeconds(){
		return this.timeoutSeconds;
	}
}
