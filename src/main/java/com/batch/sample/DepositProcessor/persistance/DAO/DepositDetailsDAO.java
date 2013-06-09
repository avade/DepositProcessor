package com.batch.sample.DepositProcessor.persistance.DAO;

import java.util.List;

import com.batch.sample.DepositProcessor.domain.DepositDetails;

/**
 * @author alex.d.ley
 *
 */
@SuppressWarnings("rawtypes")
public interface DepositDetailsDAO extends AbstractDAO{
	
	/**
	 * @param accountId
	 * @return
	 * Used to find the all of the deposits for a certain account
	 */
	public List<DepositDetails> findbyAccountID(Integer accountId);
}
