package org.predict.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.predict.data.Feature;
import org.predict.test.tensorflow.DeepFMWeightingChannel;
import org.predict.test.tensorflow.DnnWeightingSnapUp;
import org.predict.test.tensorflow.FeatureIndexGene;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	String str=String.format("Hi,%s%s%s", "小超","是个","大帅哥");
    	System.out.println(str);

        Long uid = 26585359L;
    	 if(uid==26585359 || uid==442816922){ 
    		 System.out.println("------------itemid: " + uid);
    	 }
        System.out.println( "Hello World!" );
        
        List<Feature> featureList =new ArrayList<Feature>();
        		
        featureList.add(new Feature(FeatureIndexGene.indexGenerator_8("date_prefer_index" + getWorkOrWeekendDays()), 1f));
        
        

        System.out.println( "Hello World!" );
        
        DnnWeightingSnapUp dnn=new DnnWeightingSnapUp();
        try {
        	dnn.initModelBundle();
			dnn.predict();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println( "Hello World!" );
        
        DeepFMWeightingChannel.init();
        float score= DeepFMWeightingChannel.predict();

        System.out.println( "Hello World!  score:"+score );
    }
    


    public static String getWorkOrWeekendDays() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == 1 || day == 7) {
            return "weekend";
        } else {
            return "workday";
        }
    }
}
