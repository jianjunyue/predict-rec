//package org.predict.core.abtest;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//import javax.annotation.PostConstruct;
// 
//
//import com.google.common.util.concurrent.ThreadFactoryBuilder;
// 
//import me.ele.victoria.common.MapUtils;
//import me.ele.victoria.common.VictoriaFactors;
//import me.ele.victoria.javasdk.LocalModeConfig;
//import me.ele.victoria.javasdk.VictoriaRequest;
//import me.ele.victoria.javasdk.VictoriaSDK;
//import me.ele.victoria.service.ABTestService;
// 
///**
// * http://ab.elenet.me/
// * 
// * https://yuque.antfin-inc.com/pta58k/nogkhh/kgogu5
// * */
//public class AbTestUtils {
//
////	private static final Log logger = LogFactory.getLog(AbTestUtils.class);
//
//	private final static String MODEL_ID = "10008";
//
//	private static final ThreadFactory THREAD_POOL_FACTORY = new ThreadFactoryBuilder().setNameFormat("kafka-pool-%d").build();
//	private static final ExecutorService SINGLE_THREAD_POOL = new ThreadPoolExecutor(8, 10, 0L, TimeUnit.MILLISECONDS,
//	        new LinkedBlockingQueue<Runnable>(1024), THREAD_POOL_FACTORY, new ThreadPoolExecutor.AbortPolicy());
//	
//	private VictoriaSDK sdk;
// 
//	private ABTestService abTestService=new ABTestService() ;
//
//	@PostConstruct
//	private void init() {
//		LocalModeConfig localModeConfig = LocalModeConfig.builder()
//				.setReport(true)
//				.setReporterExecutor(SINGLE_THREAD_POOL)
//				.build();
//		sdk = VictoriaSDK.builder()
//				.setAbService(abTestService)
//				.setModuleId(MODEL_ID)
//				.setCacheable(true)
//				.setLocalMode(true)
//				.setLocalModeConfig(localModeConfig)
//				.build();
//	}
//
//	public Map<String, String> get(String deviceId, Long cityId) {
//		long startTime = System.currentTimeMillis();
////		if(HuskarHandle.get().getMySwitch().isStrictDowngrade("AB_DOWNGRADE")) {
////			if (StringUtils.isEmpty(deviceId) || cityId == null) {
////				return new HashMap<>(16);
////			}
//			try {
//				init();
//				VictoriaRequest request = VictoriaRequest.builder()
//						.setClientId(deviceId)
//						.putParameter("city", cityId + "")
//						.build();
//				VictoriaFactors factors = sdk.getFactors(request);
//				return factors.getRawFactors();
//			} catch (Exception e) {
//				System.out.println(e);
////				logger.error("ABTestUtils get exception:", e);
////				Trace.newCounter("search_activity_lego.abtest_error").once();
//			} catch (Throwable a) {
////				logger.error("ABTestUtils get error:", a);
////				Trace.newCounter("search_activity_lego.abtest_error").once();
//			} finally {
////				Trace.newTimer("search_activity_lego.abtest_cost").setUpperEnable(true).value(System.currentTimeMillis() - startTime);
//			}
////		}
//		return new HashMap<>(16);
//	}
//
//	public int shunt(String deviceId, Long cityId, String abKey) {
//		Map<String, String> map = this.get(deviceId, cityId);
//		int re = 0;
//		if (!MapUtils.isEmpty(map)) {
//			switch (map.get(abKey)) {
//			case "0":
//				re = 0;
//				break;
//			case "1":
//				re = 1;
//				break;
//			case "2":
//				re = 2;
//				break;
//			case "3":
//				re = 3;
//				break;
//			default:
//				break;
//			}
//		}
//		return re;
//	}
//	
////	public ImageAbDto imageShunt(String deviceId, Long cityId, String abKey, String versionKey) {
////		Map<String, String> map = this.get(deviceId, cityId);
////		ImageAbDto dto = new ImageAbDto();
////		if (!MapUtils.isEmpty(map)) {
////			String value = map.get(abKey);
////			if(StringUtils.isEmpty(value)) {
////				dto.setAbFlag(ImageAbEnum.CLOSE);
////			} else {
////				if(value.equals(ImageAbEnum.CLOSE.getCode())) {
////					dto.setAbFlag(ImageAbEnum.CLOSE);
////				} else if(value.equals(ImageAbEnum.OPEN.getCode())) {
////					dto.setAbFlag(ImageAbEnum.OPEN);
////				} else {
////					dto.setAbFlag(ImageAbEnum.OTHER);
////					Set<Long> cityIds = this.parseCityIds(value);
////					dto.setCityIds(cityIds);
////				}
////			}
////		} else {
////			dto.setAbFlag(ImageAbEnum.CLOSE);
////		}
////		dto.setVersion(map.getOrDefault(versionKey, ""));
////		return dto;
////	}
//
//	private Set<Long> parseCityIds(String value) {
//		Set<Long> set = new HashSet<>();
//		String[] cityIds = value.split(",");
//		for (String cityId : cityIds) {
//			set.add(Long.valueOf(cityId));
//		}
//		return set;
//	}
//
//}
