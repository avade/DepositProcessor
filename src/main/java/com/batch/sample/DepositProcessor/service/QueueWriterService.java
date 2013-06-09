package com.batch.sample.DepositProcessor.service;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author alex.ley
 * This class is used to write to a blocking queue. 
 */
public class QueueWriterService {

	BlockingQueue<String> queue;
	
	public void processStringSubmission(List<String> messageToQueue) {
		queue.addAll(messageToQueue);
	}

	public void setQueue(BlockingQueue<String> queue){
		this.queue = queue;
	}
}
