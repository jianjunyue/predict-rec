package org.predict.core.predict.model;

import biz.k11i.xgboost.Predictor;
import biz.k11i.xgboost.util.FVec;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.predict.core.entity.FeatureTuple;

import com.google.common.collect.Maps;

public class XGboostHomeRecWeighting {
	  private Predictor XgboostOrder;
	    private Predictor XgboostClick;

	   private void init()   {
	        try {
				XgboostOrder = new Predictor(getClass().getClassLoader()
				        .getResourceAsStream("other/xg.home_rec_two_order.model"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				XgboostClick = new Predictor(getClass().getClassLoader()
				        .getResourceAsStream("other/xg.home_rec_two_click.model"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	        log.info("XGboostHomeRecWeighting model load is success!");
	    } 
	    public float predict(  List<FeatureTuple> features) {
	    	init();
	        Map<Integer, Float> fmap = Maps.newConcurrentMap();
	        features.forEach(r -> fmap.put(r.getIndex(), r.getData()));
	        FVec fVec = FVec.Transformer.fromMap(fmap);
	        double score = 0;
	        score = 0.5 * (XgboostOrder.predictSingle(fVec) + XgboostClick.predictSingle(fVec)) * 5000;
	      
	        return (float) score;
	    }
}
