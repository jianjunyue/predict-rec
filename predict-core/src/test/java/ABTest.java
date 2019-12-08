import java.util.Map;

import predict.BannerModelSort;

 
public class ABTest {

	public static void main(String[] args) {
		
//		AbTestUtils abtestUtils=new AbTestUtils();
//		 Map<String, String>  versionMap = abtestUtils.get("wewewe", 10000L);
//		 System.out.println(versionMap);
		
		BannerModelSort sort=new BannerModelSort();
		sort.doWeight();
	}

}
