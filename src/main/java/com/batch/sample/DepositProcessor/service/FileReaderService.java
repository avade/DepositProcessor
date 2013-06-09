package com.batch.sample.DepositProcessor.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;  
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;  

/**
 * @author alex.d.ley
 * This class implements the ItemReader interface of Spring Batch.
 * This class is used to read from a file and return the results
 * in a List<String> object. 
 */
public class FileReaderService implements ItemReader<List<String>>{

	private File file;
	private DataInputStream in;
	private BufferedReader br;
	private FileInputStream fstream;
	private int linesToLoad;
	List<String> list = new ArrayList<String>();

	public FileReaderService(){

	}

	public List<String> read() throws Exception, UnexpectedInputException, ParseException {  
		return getLines(this.linesToLoad);
	}  

	private List<String> getLines(int linesToLoad){
		//clear the last set of lines read
		list.clear();
		for(int i = 0; i < linesToLoad; i++){
			try{
				//read the line and make sure that its valid before adding
				String line = br.readLine();
				if(line != null){
					list.add(line);
				}
			}catch(Exception ex){
				break;
			}
		}
		//only return a the list if we read some lines from the file
		if(list.size() > 0){
			return list;
		}else{
			return null;
		}

	}

	public void setFileName(String fileName) throws FileNotFoundException{
		this.setFile(new File(fileName));
		//check that the file exists and if not throw an exception
		if(!getFile().exists()){
			throw new FileNotFoundException();
		}else{
			//file exists so setup the input stream and reader
			fstream = new FileInputStream(this.getFile());
			setIn(new DataInputStream(fstream));
			br = new BufferedReader(new InputStreamReader(getIn()));
		}

	}

	public void setLinesToLoad(int amount){
		this.linesToLoad = amount;
	}

	private void setFile(File file) {
		this.file = file;
	}

	private File getFile() {
		return file;
	}

	private void setIn(DataInputStream in) {
		this.in = in;
	}

	private DataInputStream getIn() {
		return in;
	}

}
