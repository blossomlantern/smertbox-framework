package com.smertbox.security.log.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.smertbox.data.redis.dao.RedisLockDao;
import com.smertbox.security.log.model.SysLog;

@Service
public class LogRedisService extends RedisLockDao {

	private Logger logger = LoggerFactory.getLogger(LogRedisService.class);
	
	// 日志锁key
	private static final String LOG_LOCK_KEY = "LOG_LOCK_KEY";
	
	private static final String LOG_KEY = "log_key";
	
	public void push(SysLog log){
		long nano = System.nanoTime();
		lock(LOG_LOCK_KEY, 1000, 3000L);// 上锁
		redisTemplate.opsForList().leftPush(LOG_KEY, log);
		unlock(LOG_LOCK_KEY);// 解锁
		long end = System.nanoTime();
		logger.debug("[request lock nano "+ nano +"]");
		logger.debug("[request lock end "+ end +"]");
		logger.debug("[use lock consume(ns) "+ (end - nano) +"]");
		logger.debug("[use lock consume(ms) "+ (end - nano)/1000000 +"]");
	}
	
	public SysLog pop(){
		long nano = System.nanoTime();
		lock(LOG_LOCK_KEY, 100, 3000L);// 上锁
		SysLog log =  (SysLog) redisTemplate.opsForList().rightPop(LOG_KEY);
		unlock(LOG_LOCK_KEY);// 解锁
		long end = System.nanoTime();
		logger.debug("[request lock nano "+ nano +"]");
		logger.debug("[request lock end "+ end +"]");
		logger.debug("[use lock consume(ns) "+ (end - nano) +"]");
		logger.debug("[use lock consume(ms) "+ (end - nano)/1000000 +"]");
		return log;
	}
	
	public List<SysLog> pops(){
		long nano = System.nanoTime();
		List<SysLog> all = new ArrayList<>();
		lock(LOG_LOCK_KEY, 100, 3000L);// 上锁
		long length = redisTemplate.opsForList().size(LOG_KEY);
		for (long i = 0; i < length; i++) {
			SysLog log = (SysLog) redisTemplate.opsForList().rightPop(LOG_KEY);
			if(log != null){
				all.add(log);
			}
		}
		unlock(LOG_LOCK_KEY);// 解锁
		long end = System.nanoTime();
		logger.debug("[request lock nano "+ nano +"]");
		logger.debug("[request lock end "+ end +"]");
		logger.debug("[use lock consume(ns) "+ (end - nano) +"]");
		logger.debug("[use lock consume(ms) "+ (end - nano)/1000000 +"]");
		return all;
	}
	
	public void remove(){
		redisTemplate.delete(LOG_KEY);
	}
	
}
