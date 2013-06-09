package com.batch.sample.DepositProcessor.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration()
public class FileReaderServiceIT extends TestCase {

	@Autowired
	FileReaderService reader;
	
	@Test
	public void testRead() throws UnexpectedInputException, ParseException, Exception {
		List<String> result = reader.read();
		TestCase.assertTrue(result.size() == 3);
	}
	
	@Test
	public void testFailedRead(){
		try {
			reader.setFileName("xyz.txt");
		} catch (FileNotFoundException e) {
			TestCase.assertTrue(true);
		}
	}
	

}
