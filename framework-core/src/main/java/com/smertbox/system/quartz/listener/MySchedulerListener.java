package com.smertbox.system.quartz.listener;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySchedulerListener implements SchedulerListener{

	private Logger logger = LoggerFactory.getLogger(MySchedulerListener.class);
	
	@Override
	public void jobAdded(JobDetail arg0) {
		// TODO Auto-generated method stub
		logger.debug("jobAdded");
	}

	@Override
	public void jobDeleted(JobKey arg0) {
		// TODO Auto-generated method stub
		logger.debug("jobDeleted");
	}

	@Override
	public void jobPaused(JobKey arg0) {
		// TODO Auto-generated method stub
		logger.debug("jobPaused");
	}

	@Override
	public void jobResumed(JobKey arg0) {
		// TODO Auto-generated method stub
		logger.debug("jobResumed");
	}

	@Override
	public void jobScheduled(Trigger arg0) {
		// TODO Auto-generated method stub
		logger.debug("jobScheduled");
	}

	@Override
	public void jobUnscheduled(TriggerKey arg0) {
		// TODO Auto-generated method stub
		logger.debug("jobUnscheduled");
	}

	@Override
	public void jobsPaused(String arg0) {
		// TODO Auto-generated method stub
		logger.debug("jobsPaused");
	}

	@Override
	public void jobsResumed(String arg0) {
		// TODO Auto-generated method stub
		logger.debug("jobsResumed");
	}

	@Override
	public void schedulerError(String arg0, SchedulerException arg1) {
		// TODO Auto-generated method stub
		logger.debug("schedulerError");
	}

	@Override
	public void schedulerInStandbyMode() {
		// TODO Auto-generated method stub
		logger.debug("schedulerInStandbyMode");
	}

	@Override
	public void schedulerShutdown() {
		// TODO Auto-generated method stub
		logger.debug("schedulerShutdown");
	}

	@Override
	public void schedulerShuttingdown() {
		// TODO Auto-generated method stub
		logger.debug("schedulerShuttingdown");
	}

	@Override
	public void schedulerStarted() {
		// TODO Auto-generated method stub
		logger.debug("schedulerStarted");
	}

	@Override
	public void schedulerStarting() {
		// TODO Auto-generated method stub
		logger.debug("schedulerStarting");
	}

	@Override
	public void schedulingDataCleared() {
		// TODO Auto-generated method stub
		logger.debug("schedulingDataCleared");
	}

	@Override
	public void triggerFinalized(Trigger arg0) {
		// TODO Auto-generated method stub
		logger.debug("triggerFinalized");
	}

	@Override
	public void triggerPaused(TriggerKey arg0) {
		// TODO Auto-generated method stub
		logger.debug("triggerPaused");
	}

	@Override
	public void triggerResumed(TriggerKey arg0) {
		// TODO Auto-generated method stub
		logger.debug("triggerResumed");
	}

	@Override
	public void triggersPaused(String arg0) {
		// TODO Auto-generated method stub
		logger.debug("triggersPaused");
	}

	@Override
	public void triggersResumed(String arg0) {
		// TODO Auto-generated method stub
		logger.debug("triggersResumed");
	}

}
