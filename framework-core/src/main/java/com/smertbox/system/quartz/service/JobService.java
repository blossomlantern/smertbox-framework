package com.smertbox.system.quartz.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.system.quartz.JobManager;
import com.smertbox.system.quartz.mapper.QrtzJobDetailsMapper;
import com.smertbox.system.quartz.mapper.QrtzJobLogMapper;
import com.smertbox.system.quartz.model.QrtzJobDetails;
import com.smertbox.system.quartz.model.QrtzJobLog;

@Service
public class JobService {

	private Logger logger = LoggerFactory.getLogger(JobService.class);
	
	@Autowired
	JobManager jobManager;
	@Autowired
	QrtzJobDetailsMapper qrtzJobDetailsMapper;
	@Autowired
	QrtzJobLogMapper qrtzJobLogMapper;
	
	public void add(String jobName,String jobDescription,String triggerName,String triggerDescription,String jobClass,String cronExpression){
		try {
			if(jobClass != null){
				Class classe =  Class.forName(jobClass);
				jobManager.addJob(jobName,jobDescription,triggerName,triggerDescription,classe,cronExpression);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	public void modify(String jobName, String cronExpression){
		jobManager.modifyJob(jobName ,cronExpression);
	}
	
	public void pause(String jobName){
		jobManager.pauseJob(jobName);
	}
	
	public void delete(String jobName){
		jobManager.deleteJob(jobName);
	}
	
	public void trigger(String jobName){
		jobManager.triggerJob(jobName);
	}
	
	public void resume(String jobName) {
		jobManager.resumeJob(jobName);
	}
	
	public QrtzJobDetails query(String jobName){
		return jobManager.queryJob(jobName);
	}
	
	public List<QrtzJobDetails> selectPageReset(List<QrtzJobDetails> list){
		Map<String, QrtzJobDetails> queryAllJobsMap = jobManager.queryAllJobsMap();
		if(queryAllJobsMap != null){
			for (QrtzJobDetails qrtzJobDetails : list) {
				QrtzJobDetails mob = queryAllJobsMap.get(qrtzJobDetails.getJobName());
				if(mob != null){
					qrtzJobDetails.setState(mob.getState());
					qrtzJobDetails.setLastTime(mob.getLastTime());
					qrtzJobDetails.setNextTime(mob.getNextTime());
				}
			}
		}
		return list;
	}

	public List<QrtzJobDetails> selectPage(QrtzJobDetails job) {
		
		return qrtzJobDetailsMapper.selectPage(job);
	}

	public int selectPageSize(QrtzJobDetails job) {
		
		return qrtzJobDetailsMapper.selectPageSize(job);
	}

	public QrtzJobDetails selectByPrimaryKey(QrtzJobDetails job) {
	
		return qrtzJobDetailsMapper.selectByPrimaryKey(job);
	}
	
	public QrtzJobDetails selectByJobName(String jobName){
		List<QrtzJobDetails> selectByJobName = qrtzJobDetailsMapper.selectByJobName(jobName);
		return selectByJobName != null ? selectByJobName.get(0) : null;
	}
	
	public int insertJobLog(QrtzJobLog record){
		
		return qrtzJobLogMapper.insertSelective(record);
	}
	
	public List<QrtzJobLog> selectLastFiveRow(String jobId){
		return qrtzJobLogMapper.selectLastFiveRow(jobId);
	}

}
