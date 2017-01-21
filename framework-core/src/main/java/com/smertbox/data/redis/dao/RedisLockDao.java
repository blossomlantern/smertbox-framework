package com.smertbox.data.redis.dao;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author:ladeng
 * @time:2016年11月25日 下午11:48:58
 * @description: Redis有锁Dao.在业务逻辑当中需要使用锁的请务必使用该dao.
 */
@Repository
public abstract class RedisLockDao {
	
	private Logger logger = LoggerFactory.getLogger(RedisLockDao.class);
	
	// 加锁标志 
	protected static final String LOCKED = "TRUE";
	// 解锁标志
	protected static final String UNLOCKED = "FALSE";
	// 毫秒与毫微秒的换算单位 1毫秒 = 1000000毫微秒 
	protected static final long MILLI_NANO_CONVERSION = 1000 * 1000L;
	// 默认超时时间（毫秒） 
	protected static final long DEFAULT_TIME_OUT = 1000;
	// 锁的超时时间（秒）过期删除 
	protected static final Long EXPIRE = 3 * 60L;
	// 锁状态
	protected boolean locked = false;
	//
	public static final Random RANDOM = new Random();
	
	@Autowired(required=true)
	protected RedisTemplate<String, Object> redisTemplate;
	
	public String echo(final String value) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return new String(connection.echo(value.getBytes()));
            }
        });
    }

	public String ping() {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }
    
	/**
	 * 获取锁 超过默认过期时间则将锁解除.
	 * @param key
	 * @param timeout
	 * @return
	 */
	public boolean lock(String key,long timeout){
    	long nano = System.nanoTime();
    	logger.debug("request lock begin:" + nano);
		timeout *= MILLI_NANO_CONVERSION;
		try {
			while ((System.nanoTime() - nano) < timeout) {
				if (redisTemplate.opsForValue().setIfAbsent(key, nano)) {
					redisTemplate.expire(key, DEFAULT_TIME_OUT, TimeUnit.SECONDS);
					long end = System.nanoTime();
					logger.debug("request lock end:" + end);
					long fee = end - nano;
					logger.debug("request lock feed:" + fee);
					this.locked = true;
					return this.locked;
				}
				// 任意休眠一段时间
				Thread.sleep(3, RANDOM.nextInt(500));
			}
		} catch (Exception e) {
			throw new RuntimeException("Locking error", e);
		}
		return false;
    }
    
    /**
     * 获取锁 超过给定的过期时间则解除锁.
     * @param key
     * @param timeout
     * @param expire
     * @return
     */
    public boolean lock(String key,long timeout, Long expire){
    	long nano = System.nanoTime();
		timeout *= MILLI_NANO_CONVERSION;
		try {
			while ((System.nanoTime() - nano) < timeout) {
				if (redisTemplate.opsForValue().setIfAbsent(key, nano)) {
					redisTemplate.expire(key, expire, TimeUnit.SECONDS);
					this.locked = true;
					return this.locked;
				}
				// 任意休眠一段时间
				Thread.sleep(3, RANDOM.nextInt(500));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
    
    /**
     * 解锁.
     * @param key
     */
    public void unlock(String key){
    	redisTemplate.delete(key);
    }
	
}
