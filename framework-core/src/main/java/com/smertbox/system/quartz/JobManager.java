package com.smertbox.system.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.smertbox.system.quartz.model.QrtzJobDetails;

/**
 * @author:ladeng
 * @time:2016年11月28日 下午11:31:35
 * @description:Job管理类，包含Job添加、修改、删除、暂停、触发操作。
 */
public class JobManager {

	private Logger logger = LoggerFactory.getLogger(JobManager.class);
	
	@Autowired
	SchedulerFactoryBean schedulerFactoryBean;
	
	private static String JOB_DEFAULT_GROUP = "JOB_DEFAULT_GROUP";
	
	//private static String TRIGGER_DEFAULT_GROUP = "TRIGGER_DEFAULT_GROUP";
	
	/**
	 * description:添加Job
	 * @param jobName Job名称
	 * @param jobClass Job类
	 * @param cronExpression Job时间表达式
	 */
	@SuppressWarnings("unchecked")
	public void addJob(String jobName,String jobDescription,String triggerName,String triggerDescription,Class jobClass,String cronExpression){
		try{
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobDetail detail = JobBuilder.newJob(jobClass).withIdentity(jobName,JOB_DEFAULT_GROUP).withDescription(jobDescription).build();
			// 表达式调度构建器	
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
			// 按新的cronExpression表达式构建一个新的trigger
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName,JOB_DEFAULT_GROUP).withDescription(triggerDescription).withSchedule(scheduleBuilder).build();
			scheduler.scheduleJob(detail, trigger);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	 * 修改Job
	 * @param jobName Job名称
	 * @param cronExpression Job时间表达式
	 */
	public void modifyJob(String jobName,String cronExpression){
		try{
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName,JOB_DEFAULT_GROUP);
			// 获取trigger
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if(trigger != null){
				// 表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
				// 按新的cronExpression表达式重新构建trigger
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				// 按新的trigger重新设置job执行
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	 * 查询一个Job
	 * @param jobName Job名称
	 */
	public QrtzJobDetails queryJob(String jobName){
		try{
			Map<String, QrtzJobDetails> queryAllJobsMap = queryAllJobsMap();
			QrtzJobDetails job = queryAllJobsMap != null ? queryAllJobsMap.get(jobName) : null;
			return job;
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}
	 
	/**
	 * 查找当前正在执行的job
	 */
	public Map<String, QrtzJobDetails> queryCurrentlyExecutingJobs(){
		try{
			Map<String, QrtzJobDetails> jobMap = new HashMap<String, QrtzJobDetails>();
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			List<JobExecutionContext> currentlyExecutingJobs = scheduler.getCurrentlyExecutingJobs();
			for (JobExecutionContext executingJob : currentlyExecutingJobs) {
				QrtzJobDetails job = new QrtzJobDetails();
				 JobDetail jobDetail = executingJob.getJobDetail();
			     JobKey jobKey = jobDetail.getKey();
			     Trigger trigger = executingJob.getTrigger();
			     Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			     job.setJobName(jobKey.getName());
			     job.setJobGroup(jobKey.getGroup());
			     job.setTriggerName(trigger.getKey().getName());
			     job.setNextTime(trigger.getNextFireTime());
			     job.setLastTime(trigger.getPreviousFireTime());
			     job.setState(triggerState.name());
			     if (trigger instanceof CronTrigger) {
			         CronTrigger cronTrigger = (CronTrigger) trigger;
			         String cronExpression = cronTrigger.getCronExpression();
			         job.setCronExpression(cronExpression);
			     }
			     jobMap.put(job.getJobName(), job);
			}
			return jobMap;
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}
	
	/**
	 * 查找计划中的job
	 */
	public Map<String, QrtzJobDetails> queryAllJobsMap(){
		try{
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
			Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
			Map<String, QrtzJobDetails> jobMap = new HashMap<String, QrtzJobDetails>();
			for (JobKey jobKey : jobKeys) {
			    List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			    for (Trigger trigger : triggers) {
			    	QrtzJobDetails job = new QrtzJobDetails();
			    	 Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			        job.setJobName(jobKey.getName());
			        job.setJobGroup(jobKey.getGroup());
			        job.setTriggerName(trigger.getKey().getName());
				    job.setNextTime(trigger.getNextFireTime());
				    job.setLastTime(trigger.getPreviousFireTime());
				    job.setState(triggerState.name());
			        if (trigger instanceof CronTrigger) {
			            CronTrigger cronTrigger = (CronTrigger) trigger;
			            String cronExpression = cronTrigger.getCronExpression();
			            job.setCronExpression(cronExpression);
			        }
			        jobMap.put(job.getJobName(), job);
			    }
			}
			return jobMap;
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}
	
	/**
	 * 查找计划中的job
	 */
	public List<QrtzJobDetails> queryAllJobsList(){
		try{
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
			Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
			List<QrtzJobDetails> jobList = new ArrayList<QrtzJobDetails>();
			for (JobKey jobKey : jobKeys) {
			    List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			    for (Trigger trigger : triggers) {
			    	QrtzJobDetails job = new QrtzJobDetails();
			    	 Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			        job.setJobName(jobKey.getName());
			        job.setJobGroup(jobKey.getGroup());
			        job.setTriggerName(trigger.getKey().getName());
				    job.setNextTime(trigger.getNextFireTime());
				    job.setLastTime(trigger.getPreviousFireTime());
				    job.setState(triggerState.name());
			        if (trigger instanceof CronTrigger) {
			            CronTrigger cronTrigger = (CronTrigger) trigger;
			            String cronExpression = cronTrigger.getCronExpression();
			            job.setCronExpression(cronExpression);
			        }
			        jobList.add(job);
			    }
			}
			return jobList;
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}
	
	/**
	 * 暂停一个Job
	 * @param jobName Job名称
	 */
	public void pauseJob(String jobName){
		try{
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(jobName,JOB_DEFAULT_GROUP);
			scheduler.pauseJob(jobKey);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	 * 恢复一个Job
	 * @param jobName Job名称
	 */
	public void resumeJob(String jobName){
		try{
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(jobName,JOB_DEFAULT_GROUP);
			scheduler.resumeJob(jobKey);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	 * 触发一个Job
	 * @param jobName Job名称
	 */
	public void triggerJob(String jobName){
		try{
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(jobName,JOB_DEFAULT_GROUP);
			scheduler.triggerJob(jobKey);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	/**
	 * 删除一个Job
	 * @param jobName Job名称
	 */
	public void deleteJob(String jobName){
		try{
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(jobName,JOB_DEFAULT_GROUP);
			scheduler.deleteJob(jobKey);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
}
