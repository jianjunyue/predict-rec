package org.predict.test.redis;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.predict.test.guava.ShopInfo;

import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public class RedisTest {


    private Schema<ShopInfo> schema = RuntimeSchema.getSchema(ShopInfo.class);
    private final ShopInfo EMPTY_SHOP_INFO = new ShopInfo();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public Map<Long, ShopInfo> doLoadAll(List<Long> keys) {
        Map<Long, ShopInfo> map =null;// redisClient.mget("shopInfo:%s", keys, shopInfoFunction);
        keys.forEach(k -> map.putIfAbsent(k, EMPTY_SHOP_INFO));
        return map;
    }
	
    private final Function<byte[], ShopInfo> shopInfoFunction = v -> {
        ShopInfo shopInfo = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(v, shopInfo, schema);
        return shopInfo;
    };

}
