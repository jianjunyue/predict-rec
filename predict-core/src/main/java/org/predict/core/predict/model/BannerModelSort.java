package org.predict.core.predict.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.predict.core.entity.FeatureTuple;
import org.predict.core.entity.ScoreDto;

import com.google.common.collect.Lists;

public class BannerModelSort {

	private BannerModelXG bannerModelXG = new BannerModelXG();

	public void doWeight() {
		ScoreDto dto = new ScoreDto();
		List<FeatureTuple> featureTuples = getModelLog(dto);
		double score = bannerModelXG.doWeight(featureTuples);
	}

	public List<FeatureTuple> getModelLog(ScoreDto scoreDto) {
		List<FeatureTuple> featureTuples = Lists.newArrayList();
		featureTuples.add(new FeatureTuple(0, scoreDto.getRestaurantNum()));
		featureTuples.add(new FeatureTuple(1, scoreDto.getFoodNum()));
		featureTuples.add(new FeatureTuple(2, scoreDto.getFirstFoodCount()));
		featureTuples.add(new FeatureTuple(3, ((Double) scoreDto.getFirstFoodScore()).floatValue()));
		featureTuples.add(new FeatureTuple(4, scoreDto.getSecondFoodCount()));
		featureTuples.add(new FeatureTuple(5, ((Double) scoreDto.getSecondFoodScore()).floatValue()));
		featureTuples.add(new FeatureTuple(6, scoreDto.getFirstRestaurantCount()));
		featureTuples.add(new FeatureTuple(7, ((Double) scoreDto.getFirstRestaurantScore()).floatValue()));
		featureTuples.add(new FeatureTuple(8, scoreDto.getSecondRestaurantCount()));
		featureTuples.add(new FeatureTuple(9, ((Double) scoreDto.getSecondRestaurantScore()).floatValue()));
		featureTuples.add(new FeatureTuple(10, scoreDto.getUserCount()));
		featureTuples.add(new FeatureTuple(11, ((Double) scoreDto.getUserScore()).floatValue()));
		featureTuples.add(new FeatureTuple(12, ((Double) scoreDto.getNowPrice()).floatValue()));
		featureTuples.add(new FeatureTuple(13, this.getUserOrderNum()));
		featureTuples.add(new FeatureTuple(14, this.getClickExposureRatio()));
		featureTuples.add(new FeatureTuple(15, this.getOrderClickRatio()));
		featureTuples.add(new FeatureTuple(16, this.getOrderDistincNum()));
		if (featureTuples.size() > 0) {
			System.out.println(listToString(featureTuples));
			featureTuples = featureTuples.stream().filter(x -> x.getIndex() != -1)
					.filter(x -> Math.abs(x.getData()) > 1e-5).filter(x -> Math.abs(x.getData()) < 1e10)
					.collect(Collectors.toList());
			Collections.sort(featureTuples);

			System.out.println(listToString(featureTuples));
		}
		return featureTuples;
	}

	private long getOrderDistincNum() {
		return 10;
	}

	private float getOrderClickRatio() {
		return 0.0f;
	}

	private float getClickExposureRatio() {
		return 0.0f;
	}

	private Long getUserOrderNum() {
		return 0L;
	}

	public String listToString(List<FeatureTuple> features) {
		return features.stream().map(f -> String.format("%s:%s", f.getIndex(), f.getData()))
				.collect(Collectors.joining(" "));
	}
}
