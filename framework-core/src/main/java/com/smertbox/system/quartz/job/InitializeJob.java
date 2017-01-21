package com.smertbox.system.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitializeJob implements Job{

	private Logger logger = LoggerFactory.getLogger(InitializeJob.class);
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.debug("[+++++++++++++++++++++++ InitJob executed! ++++++++++++++++++++++++]");
	}

}
