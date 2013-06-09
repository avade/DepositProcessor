package com.batch.sample.DepositProcessor.service;

import com.batch.sample.DepositProcessor.domain.DepositDetails;
import com.batch.sample.DepositProcessor.exception.DepositProcessingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.batch.sample.DepositProcessor.helper.JSONtoDepositDetailsConverter;

/**
 * @author alex.d.ley
 * A class used to process a deposit details JSON string into a DepositDetails object
 * and persist this to a database.
 */
public class ProcessDepositDetailsToDBService implements DepositProcessService {

	@Autowired
	protected DepositDetailsService depositDetailsService;
	@Autowired
	private JSONtoDepositDetailsConverter jsonConverter;

	Logger logger = Logger.getLogger(this.getClass());
	
	@Transactional
	public void processStringSubmission(String jsonString) {  
		try{
			//convert the string into 
			DepositDetails depositDetails = jsonConverter.convertJSONStringtoDepositDetails(jsonString);
			if(depositDetails != null){
				depositDetailsService.save(depositDetails);
			}else{
				throw new DepositProcessingException("Error Processing: " + jsonString);
			}
			
		}catch(DepositProcessingException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex){
			logger.error("Error Processing: " + jsonString);
		}
	}

	public void setDepositDetailsService(DepositDetailsService depositDetailsService) {
		this.depositDetailsService = depositDetailsService;
	}

	public void setJsonConverter(JSONtoDepositDetailsConverter jsonConverter) {
		this.jsonConverter = jsonConverter;
	}

}
