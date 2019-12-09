package org.predict.base.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisClient {
	 

	private JedisPool jedisPool = null;

    
	public RedisClient() {
		RedisPool redisPool=new RedisPool();
		this.jedisPool = redisPool.getRankJedisPool();
	}
	
    public List<String> mget(final String... keys) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.mget(keys);
        } catch (Exception e) {
			throw e;
		}  finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.get(key);
		} catch(Exception e) { 
			throw e;
		} finally { 
			jedis.close();
		}
	}

	public byte[] get(byte[] key) {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.get(key);
		} catch(Exception e) { 
			throw e;
		} finally { 
			jedis.close();
		}
	}

}
