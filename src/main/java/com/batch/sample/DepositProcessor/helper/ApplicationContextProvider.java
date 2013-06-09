package com.batch.sample.DepositProcessor.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author alex.ley
 * Used to provide the application context as opposed to implementing 
 * the ApplicationContextAware interface. 
 */
public class ApplicationContextProvider implements ApplicationContextAware {

	private static ApplicationContext ctx; 
	
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		ApplicationContextProvider.ctx = ctx;
	}
	
	public static ApplicationContext getApplicationContext(){
		return ApplicationContextProvider.ctx;
	}

}
