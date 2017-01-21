package com.smertbox.data.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author:ladeng
 * @time:2016年11月25日 下午11:49:40
 * @description: Redis无锁方法Dao.在无需使用锁的业务逻辑当中可以使用该dao,否则请使用有锁DAO
 */
@Repository
public abstract class RedisDao<K,V> {
	
	@Autowired(required=true)
	protected RedisTemplate<K, V> redisTemplate;
	
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
}
