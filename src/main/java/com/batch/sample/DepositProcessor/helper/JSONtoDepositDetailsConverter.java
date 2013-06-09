package com.batch.sample.DepositProcessor.helper;


import com.batch.sample.DepositProcessor.domain.DepositDetails;


/**
 * @author alex.d.ley
 * JSONtoDepositDetailsConverter is the interface used for
 * any class that wants to convert a JSON string to a 
 * deposit details object.
 */
public interface JSONtoDepositDetailsConverter {

	public DepositDetails convertJSONStringtoDepositDetails(String json);
}
