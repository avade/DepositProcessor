package com.batch.sample.DepositProcessor.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class QueueReaderServiceTest extends TestCase{
	
	QueueReaderService queueReaderService;
	
	BlockingQueue<String> blockingQueue;
	
	@Before
	public void setUp() throws Exception{
		queueReaderService = new QueueReaderService();
		blockingQueue = new LinkedBlockingQueue<String>();
		queueReaderService.setQueue(blockingQueue);
		queueReaderService.setTimeoutSeconds(5);
		super.setUp();
	}
	
	@Test
	public void testReadQueue() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception{
		String input = "hello";
		blockingQueue.add(input);
		String result = queueReaderService.read();
		TestCase.assertEquals(input, result);
	}
}
