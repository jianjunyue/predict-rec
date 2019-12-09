package org.predict.base.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties redis_properties = new Properties();
    
    static {
        try {
        	redis_properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("redis/redis.properties"));
        } catch (IOException e) {
           
        }
    }
    
    public static Properties getRedisProperties() {
    	return  redis_properties;
    }

}
