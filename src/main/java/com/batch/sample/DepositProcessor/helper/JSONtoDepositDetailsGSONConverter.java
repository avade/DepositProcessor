package com.batch.sample.DepositProcessor.helper;

import com.batch.sample.DepositProcessor.domain.DepositDetails;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * @author alex.d.ley
 * Implements the JSONtoDepositDetailsConverter interface and converts
 * a JSON string to a DepositDetails object using the Gson library.
 */
@Component
public class JSONtoDepositDetailsGSONConverter implements JSONtoDepositDetailsConverter {

	public DepositDetails convertJSONStringtoDepositDetails(String json){
		return new Gson().fromJson(json, DepositDetails.class);
	}

}
