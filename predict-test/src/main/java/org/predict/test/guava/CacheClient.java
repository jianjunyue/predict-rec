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

public class CacheClient {
	private static Cache<String,Object> cache;
    static {
	    // initialCapacity 初始化容量
	    // concurrentLevel 并发的线程数
	    // expireAfterWrite 写入多长时间后，失效
        cache = CacheBuilder.newBuilder()
                .initialCapacity(240000)
                .maximumSize(800000)
                .build();
        //手动加载数据
        cache.put("1","name11");
        cache.put("2","name12");
        cache.put("3","name13");
        cache.put("4","name14");
        cache.put("5","name15");
        cache.put("6","name16");
        
    } 
    
    public static void main(String[] args) throws ExecutionException {
    	List<String> shopIdList=new ArrayList<String>();
    	shopIdList.add("1");
    	shopIdList.add("2");
    	Map<String, Object>	map=cache.getAllPresent(shopIdList);
        //获取一个不存在的key
        System.out.println("------------------");
//        System.out.println(cache.get("7", loader) );
        System.out.println(cache.getIfPresent("7"));
        //获取一个存在的key
        System.out.println(cache.getIfPresent("1"));
        //获取一个不存在的key，自己定义一个加载方法
        System.out.println(cache.get("7",new Callable(){
            @Override
            public Object call() throws Exception {
	            //返回值，一定不能为null
                return "dadad";
            }
        }));
        System.out.println(cache.getIfPresent("7"));
        cache.invalidate("1");
        System.out.println("------------------");

        cache.invalidateAll();
    } 
}
