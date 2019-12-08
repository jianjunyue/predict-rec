package org.predict.core.predict.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.predict.core.entity.FeatureTuple;

import com.google.common.collect.Maps;

import biz.k11i.xgboost.Predictor;
import biz.k11i.xgboost.util.FVec;

public class XGBannerModel {

	private static Predictor predictorOrder = null;

	private static XGBannerModel instance = new XGBannerModel();

	public static XGBannerModel getInstance() {
		if (predictorOrder == null) {
			instance.init();
		}
		return instance;
	}

	private void init() {
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			predictorOrder = new Predictor(cl.getResourceAsStream("banner_model/xg.model.out.txt20180205161100"));
		} catch (IOException ex) {

		}
	}
	
	public Double doWeight(List<FeatureTuple> features) {
		Double re = 0.0;
		try {
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
