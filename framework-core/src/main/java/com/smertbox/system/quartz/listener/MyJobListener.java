package com.smertbox.system.quartz.listener;

import java.util.Calendar;
import java.util.UUID;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.smertbox.system.quartz.model.QrtzJobLog;
import com.smertbox.system.quartz.service.JobService;

/**
 * @author:ladeng
 * @time:2016年11月27日 下午8:00:57
 * @description:监听定时任务执行情况，并将执行数据存储到数据库。
 */
public class MyJobListener implements JobListener{

	private Logger logger = LoggerFactory.getLogger(MyJobListener.class);
	
	@Autowired
	JobService jobService;
	
	@Override
	public String getName() {
		
		return "SmertBox JobListener";
	}

	/**
	 * Scheduler 在 JobDetail 即将被执行，但又被 TriggerListener 否决了时调用这个方法。
	 */
	@Override
	public void jobExecutionVetoed(JobExecutionContext arg0) {
		logger.debug("jobExecutionVetoed");
	}

	/**
	 * Scheduler 在 JobDetail 将要被执行时调用这个方法。
	 */
	@Override
	public void jobToBeExecuted(JobExecutionContext arg0) {
		QrtzJobLog record = new QrtzJobLog();
		record.setId(UUID.randomUUID().toString());
		record.setExecuteTime(Calendar.getInstance().getTime());
		record.setJobId(arg0.getJobDetail().getKey().getName());
		record.setExecuteContent(arg0.getTrigger().getKey().getName());
		jobService.insertJobLog(record);
	}

	/**
	 * Scheduler 在 JobDetail 被执行之后调用这个方法。
	 */
	@Override
	public void jobWasExecuted(JobExecutionContext arg0, JobExecutionException arg1) {
		// TODO Auto-generated method stub
		logger.debug("jobWasExecuted");
	}

}
