package com.batch.sample.DepositProcessor.service;

import com.batch.sample.DepositProcessor.domain.DepositDetails;

/**
 * @author alex.d.ley
 * Interface for a deposit details service. This provides operations that
 * any deposit details service provider should provide.
 *
 */
public interface DepositDetailsService {
	
	/**
	 * @param deposit
	 * saves the deposit details object to a location
	 */
	public void save(DepositDetails deposit);
	
}
