package org.predict.base.redis;

import java.util.Properties;
import org.predict.base.util.PropertiesUtil;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

	public JedisPool getRankJedisPool() {
		JedisPoolConfig redisConfig = new JedisPoolConfig();
		redisConfig.setMaxIdle(100); // 对象最大空闲时间
		redisConfig.setMaxWaitMillis(1000L); // 获取对象时最大等待时间
		redisConfig.setMaxTotal(100); // 最大活动的对象个数
		int timeout = 100;
		Properties redis_properties = PropertiesUtil.getRedisProperties();
		String host = redis_properties.get("rank_redis_host").toString();
		int port = Integer.parseInt(redis_properties.get("rank_redis_host").toString());
		JedisPool pool = new JedisPool(redisConfig, host, port, timeout);
		return pool;
	}
	
}
