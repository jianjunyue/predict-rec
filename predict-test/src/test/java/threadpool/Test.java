package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
 

public class Test {

	  private static final ExecutorService COMMON_POOL = new ThreadPoolExecutor(400, 500, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100000), new ThreadFactoryBuilder().setNameFormat("common-pool-%d").build());
	  private static final ExecutorService COMMON_POOL1 = new ThreadPoolExecutor(400, 500, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100000));
		public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
