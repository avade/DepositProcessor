package com.batch.sample.DepositProcessor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class QueueWriterServiceTest extends TestCase {
	
	QueueWriterService queueWriter;

	BlockingQueue<String> blockingQueue;

	@Before
	public void setUp() throws Exception{
		queueWriter = new QueueWriterService();
		blockingQueue = new LinkedBlockingQueue<String>();
		queueWriter.setQueue(blockingQueue);
		super.setUp();
	}
	
	@Test
	public void testPositiveAddToQueue(){
		List<String> list = new ArrayList<String>();
		list.add("test");
		list.add("test2");
		queueWriter.processStringSubmission(list);
		List<String> results = new ArrayList<String>();
		blockingQueue.drainTo(results);
		TestCase.assertEquals(results, list);
	}
	
	@Test
	public void testNegitiveAddToQueue(){
		List<String> list = new ArrayList<String>();
		list.add("test");
		list.add("test2");
		queueWriter.processStringSubmission(list);
		List<String> results = new ArrayList<String>();
		blockingQueue.drainTo(results);
		list.add("test3");
		TestCase.assertNotSame(results, list);
	}
	
}
