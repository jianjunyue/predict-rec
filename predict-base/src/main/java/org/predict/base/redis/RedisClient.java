package org.predict.base.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisClient {

	private static final Logger logger = LoggerFactory.getLogger(RedisClient.class);

	private JedisPool jedisPool = null;

	public RedisClient() {
		RedisPool redisPool = new RedisPool();
		this.jedisPool = redisPool.getRankJedisPool();
	}

	public <K, V> Map<K, V> mget(List<K> keyList, Function<byte[], V> function) {
		Map<K, V> map = new HashMap<>();
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[][] keys = new byte[keyList.size()][];
			for (int i = 0; i < keyList.size(); i++) {
				keys[i] = String.valueOf(keyList.get(i)).getBytes();
			}

			List<byte[]> results = jedis.mget(keys);

			for (int i = 0; i < keyList.size(); i++) {
				byte[] b = results.get(i);
				if (b != null) {
					map.put(keyList.get(i), function.apply(b));
				}
			}
		} catch (Exception e) {
			logger.error("RedisClient mget is error ", e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return map;
	}

	public List<String> mget(String... keys) {
		List<String> result = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.mget(keys);
		} catch (Exception e) {
			logger.error("RedisClient mget is error ", e);
		} finally {
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
		} catch (Exception e) {
			throw e;
		} finally {
			jedis.close();
		}
	}

	public byte[] get(byte[] key) {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			throw e;
		} finally {
			jedis.close();
		}
	}

}
