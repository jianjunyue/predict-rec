package Collectors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.lang.Thread;

import org.apache.commons.lang3.SerializationUtils;

import org.apache.commons.lang3.StringUtils;
//import com.google.common.util.concurrent.
import org.apache.commons.lang3.ThreadUtils;

import com.alibaba.fastjson.JSONObject;

import Test.DoubleCheckedSingleton;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Singleton;
//import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.cron.CronUtil;
public class Test {

	public static void main(String[] args) {
		CronUtil.start();
		 Singleton.get(DoubleCheckedSingleton.class);
//		DoubleCheckedSingleton d=new DoubleCheckedSingleton();
		DoubleCheckedSingleton.getSingleInstance().test();
		ClassPathResource resource = new ClassPathResource("test.properties");
		resource.getStream();
		String a = "１２３４５６７８９￥￥";
		 IdUtil.randomUUID();
		 String simpleUUID = IdUtil.simpleUUID();
		//结果为"123456789"
		String dbc = Convert.toDBC(a);
		UUID.randomUUID();
	     System.out.println(dbc);
		// TODO Auto-generated method stub
		Collectors.joining(",", "[", "]");

        List<Integer> featureList = new ArrayList<>();
        Map<Integer, Integer> featureMap = new HashMap<>();
	     int DENSE_FIELD = 338;
	     IntStream.range(0, DENSE_FIELD).forEach(key -> {
	            int base = key * 21;
	            int value = featureMap.getOrDefault((key + 1), 21) + base ;
	            featureList.add(value);
	        });

	     System.out.println(featureList.size());
	     

	     System.out.println(JSONObject.toJSONString(featureList));
	     
		
//		ThreadUtils
//		StringUtils
		//使用jdk自身配置好的日期格式
		DateTimeFormatter formatter1 = DateTimeFormatter.ISO_DATE_TIME;

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		LocalDateTime date1 = LocalDateTime.now();
		//反过来调用也可以 : date1.format(formatter1);
		String date1Str = formatter1.format(date1);

        LocalDateTime formatedDateTime = LocalDateTime.parse(date1Str, formatter2); //将时间日期对象转为格式化后的时间日期对象
		System.out.println(date1Str);
	}

}
