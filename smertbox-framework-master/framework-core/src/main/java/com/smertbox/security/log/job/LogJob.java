package com.smertbox.security.log.job;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.smertbox.security.log.model.SysLog;
import com.smertbox.security.log.service.LogRedisService;
import com.smertbox.security.log.service.LogService;
import com.smertbox.util.properties.PropertiesUitl;
/**
 * @author:ladeng
 * @time:2016年12月13日 下午11:56:57
 * @description:将redis缓存日志数据存入数据库
 */
public class LogJob implements Job{

	private Logger logger = LoggerFactory.getLogger(LogJob.class);
	
	@Autowired
	LogRedisService logRedisService;
	@Autowired
	LogService logService;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.debug("[+++++++++++++++++++++++ LogJob executed! ++++++++++++++++++++++++]");
		String updateKey = PropertiesUitl.getInstance().getProperty("logs/log.properties", "logger.update.keyword");
		String deleteKey = PropertiesUitl.getInstance().getProperty("logs/log.properties", "logger.delete.keyword");
		String uk[] = StringUtils.isNotBlank(updateKey) ? updateKey.split(",") : null;
		String dk[] = StringUtils.isNotBlank(deleteKey) ? deleteKey.split(",") : null;
		List<SysLog> list = logRedisService.pops();
		if(list != null && list.size() > 0){
			for (SysLog sysLog : list) {
				for (int i = 0; i < uk.length; i++) {
					if(sysLog.getResUrl().contains(uk[i])){
						sysLog.setOpType(2);// update operation
						continue;
					}
				}
				for (int j = 0; j < dk.length; j++) {
					if(sysLog.getResUrl().contains(dk[j])){
						sysLog.setOpType(3);// delete operation
						continue;
					}
				}
				
				if(sysLog.getOpType() == null || (sysLog.getOpType() != null && sysLog.getOpType() ==0)){
					sysLog.setOpType(1);// query operation
				}
				
				logService.insert(sysLog);
			}
		}
	}

}
