package org.predict.core.predict.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.predict.core.entity.FeatureTuple;

import com.google.common.collect.Maps;

import biz.k11i.xgboost.Predictor;
import biz.k11i.xgboost.util.FVec;

public class BannerModelXG {

	private Predictor predictorOrder;

	private void init() throws IOException {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		// [('f14', 830.6752753788686), ('f1', 111.59905448684214), ('f0',
		// 102.64717723297979), ('f16', 33.41075071428572), ('f15', 32.18863038482758),
		// ('f13', 27.370293319587624)]
		predictorOrder = new Predictor(cl.getResourceAsStream("banner_model/xg.model.out.txt20180205161100"));
	}

	public Double doWeight(List<FeatureTuple> features) {
		Double re = 0.0;
		try {
			init();
			if (features != null && features.size() > 0) {
				Map<Integer, Float> map = Maps.newHashMap();
				features.forEach(r -> map.put(r.getIndex(), r.getData()));
				re = predictorOrder.predictSingle(FVec.Transformer.fromMap(map));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return re;
	}

}
