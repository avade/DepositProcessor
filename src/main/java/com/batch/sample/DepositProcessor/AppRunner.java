package com.batch.sample.DepositProcessor;

import java.io.File;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.batch.sample.DepositProcessor.helper.ApplicationContextProvider;

/**
 * @author alex.d.ley
 * Application runner. This class invokes Spring Batch to launch the processing job.
 * Also contains the main method for the application, this is uses to validate the input args and 
 * start the runner.
 */
@Component
public class AppRunner 
{
	public static String fileToProcess;

    public static void main( String[] args )
    {
    	//check if any arguments were passed in?
    	if(args.length > 0){
    		//get the first value as this is the file path
        	fileToProcess = args[0];
        	//check if this file exists and if it does load the spring context
        	if(new File(fileToProcess).exists()){
        		new ClassPathXmlApplicationContext("spring-allconfigs.xml");
        		AppRunner runner = (AppRunner) ApplicationContextProvider.getApplicationContext().getBean("appRunner");
        		runner.execute();
        	}
    	}else{
    		System.out.println("no file specified : exiting");
    	}
    }
    
    public void execute(){
    	
    	System.out.println("Deposit processing Starting");
        ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
        
        //create a start time 
        long start = new Date().getTime();
        String message = "Import Complete - check log entries not imported";
        
        //launch the job via the Job Launcher
        JobLauncher launcher = (JobLauncher) ctx.getBean("jobLauncher");
        Job job = (Job) ctx.getBean("proccessLogJob");
        try {
			launcher.run(job, new JobParameters());
		} catch (Exception ex){
			message = "Issue with Import Job - check log for details";
		}

		//log the end time
        long end = new Date().getTime();
        
        //output the difference between the start and the end time
        System.out.println("Ran in: " + (end - start) + " miliseconds");
        System.out.println(message);
    }
    
}
