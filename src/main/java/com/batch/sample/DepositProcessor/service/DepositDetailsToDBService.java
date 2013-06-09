package com.batch.sample.DepositProcessor.service;

import com.batch.sample.DepositProcessor.domain.DepositDetails;
import com.batch.sample.DepositProcessor.persistance.DAO.DepositDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alex.d.ley
 * Implements the DepositDetailsService interface. This class provides
 * functionality allowing the object to be persisted via a 
 * depositDetailsDAO.
 */
@Service
public class DepositDetailsToDBService implements DepositDetailsService {

	@Autowired
	protected DepositDetailsDAO depositDetailsDAO;
	
	@SuppressWarnings("unchecked")
	public void save(DepositDetails depositDetails) {
		depositDetailsDAO.save(depositDetails);
	}
	
	public void setDepositDetailsDAO(DepositDetailsDAO depositDetailsDAO){
		this.depositDetailsDAO = depositDetailsDAO;
	}

}
