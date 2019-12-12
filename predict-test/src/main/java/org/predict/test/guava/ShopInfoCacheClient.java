package org.predict.test.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.hash.Hashing;


public class ShopInfoCacheClient {

	private static Cache<Long,ShopInfo> shopInfoCache= null;
	
	static {
		shopInfoCache= CacheBuilder.newBuilder()
	            .initialCapacity(240000)
	            .maximumSize(800000)
	            .build();
		System.out.println("ShopInfoCacheClient static");
	}
	
	public static void put(ShopInfo shopInfo) {
		shopInfoCache.put(shopInfo.getShopId(),shopInfo); 
	}
	
	public static void put(Map<Long,ShopInfo> mapinfo) {
		shopInfoCache.putAll(mapinfo);; 
	}
	
	public static Map<Long,ShopInfo> get(List<Long> ids){
		return shopInfoCache.getAllPresent(ids);
	}
	
}
