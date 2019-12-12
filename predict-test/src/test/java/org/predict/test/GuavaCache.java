package org.predict.test;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.predict.test.guava.ShopInfo;
import org.predict.test.guava.ShopInfoCacheClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GuavaCache {

	public static void main(String[] args) {
		ShopInfo shopInfo =new ShopInfo();
		
		Map<Long,ShopInfo> mapinfo=new HashMap<Long,ShopInfo>();
		for(int i=0;i<100;i++) {
			shopInfo.setShopId(i);
			shopInfo.setCityId(10000+i);
			shopInfo.setName("name_"+i);  
			mapinfo.put(shopInfo.getShopId(), shopInfo);
			ShopInfoCacheClient.put(shopInfo);
		}
		ShopInfoCacheClient.put(mapinfo);
		
		List<Long> list=new ArrayList<Long>();
		list.add(1L);
		list.add(50L);
		list.add(100L);
		list.add(1000L);
		
		Map<Long,ShopInfo> MAP=ShopInfoCacheClient.get(list);
//		String str= JSON.toJSONString(MAP);
		String str= JSONObject.toJSONString(MAP);
		System.out.print(str);

	}

}
