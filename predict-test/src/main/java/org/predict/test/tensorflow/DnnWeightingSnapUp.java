package org.predict.test.tensorflow;

import com.google.common.collect.Lists; 
import org.apache.commons.collections.CollectionUtils;
import org.predict.data.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.*;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DnnWeightingSnapUp {
	private static final Logger log = LoggerFactory.getLogger(DnnWeightingSnapUp.class); 
	    private static Session sess;
	    private static Tensor keepProb;
	    private static Tensor isTrain;
	    private static SavedModelBundle savedModelBundle;

	    public static void initModelBundle(){ 
	        try{
	            URL t = DnnWeightingSnapUp.class.getClassLoader().getResource("DnnModelLu/saved_model.pb");
	            assert t != null;
	            Path path = Paths.get(t.getPath());
	            savedModelBundle = SavedModelBundle.load(path.getParent().toAbsolutePath().toString(), "serve");

		        keepProb = Tensor.create(1.0f, new long[]{});
		        isTrain = Tensor.create(false, new long[]{});
		        sess = savedModelBundle.session();
	        }catch (Exception e){
	            log.error(e.toString());
	            System.exit(0);
	        }
	    }  
 
	    public  void predict() throws Exception { 
	        int foodListSize = 5; 

	        float[][] feature = new float[foodListSize][192];
	        List<List<Feature>> featureValues = convertFeature( feature);

	        Tensor x = Tensor.create(feature, new long[]{foodListSize, 192});
	        float[][] dnnOut = new float[foodListSize][1];
	        List<Tensor<?>> out=sess.runner()
	                .feed("feature", x)
	                .feed("keep_prob", keepProb)
	                .feed("is_train", isTrain)
	                .fetch("predict")
	                .run();
	        out.get(0).copyTo(dnnOut);
	        x.close();
	        for (Tensor tensor : out) {
	            tensor.close();
	        }
	        IntStream.range(0, foodListSize).forEach(idx -> System.out.println(dnnOut[idx][0] * 100));
	      
	    }


	    private List<List<Feature>> convertFeature( float[][] features) {
	         
	        List<List<Feature>> featureValues = Lists.newArrayList(); 
	        for (int i = 0; i < features.length; i++) {
	        	float[] foodFeaturesForDnn= {i};
	            features[i] = foodFeaturesForDnn;
	        }
	        List<Feature> list=new ArrayList<Feature>();
	        list.add(new Feature(1,2));
	        featureValues.add(list);
	        return featureValues;
	    }
	    private List<Feature> features() {

//	        List<Feature> featureList = new FoodFeatureBuilder()
//	                .append(food.getFoodRealTime())
//	                .append(food.getFoodAttributes())
//	                .append(food.getFoodInfo())
//	                .append(food.getShopInfo())
//	                .append(userProfile)
//	                .append(getJsonRestaurantInfo(userProfile, food.getShopId()))
//	                .result();
	        

	        List<Feature> featureList =new ArrayList<Feature>();
	        featureList.add(new Feature(1,111));
	        featureList.add(new Feature(2,222));
	        featureList.add(new Feature(3,333));
	        featureList.add(new Feature(4,444));
	        featureList.add(new Feature(5,555));
	        featureList.add(new Feature(6,666));
	        featureList.add(new Feature(FeatureIndexGene.indexGenerator_8("date_prefer_index" + getWorkOrWeekendDays()), 1f));
	        featureList = featureList
	                .stream()
	                .filter(feature -> feature.getIndex() != -1 && Math.abs(feature.getValue()) > 1e-5 && Math.abs(feature.getValue()) < 1e10)
	                .collect(Collectors.toList());
	        featureList.sort((f1, f2) -> Float.compare(f1.getIndex(), f2.getIndex()));
	        FoodDnnConvert convert = new FoodDnnConvert();
	        float[] featureFloat = convert.convert(featureList);
//	        food.setFoodFeaturesForDnn(featureFloat);
	        return featureList;
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
