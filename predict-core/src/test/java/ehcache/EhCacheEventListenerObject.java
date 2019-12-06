//package ehcache;
//
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.ehcache.event.CacheEvent;
//import org.ehcache.event.CacheEventListener;
// 
//
///**
// * 
//* @ClassName: EhCacheEventListenerObject 
//* @Description: 一级缓存监听
//* @author yzw 
//* @date 2018年7月25日 下午5:25:47 
//*
// */
//@SuppressWarnings("rawtypes")
//public class EhCacheEventListenerObject implements CacheEventListener {
//	
//	protected Logger logger = LogManager.getLogger(getClass());
//	
//	@Override
//	public void onEvent(CacheEvent event) {
//		//一级缓存超时放进二级缓存中
//		logger.info("超时了,key:"+event.getKey());		
//		CacheUtil.getCache().set(event.getKey().toString(), event.getOldValue().toString());
//		CacheUtil.getCache().expire(event.getKey().toString(), 60*5);		
//	}
//}