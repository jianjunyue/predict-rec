package org.predict.core.entity;

import java.util.List;
import java.util.stream.Collectors;

public class FeatureTuple implements Comparable<FeatureTuple> {
	int index;
	float data;

	public FeatureTuple(int index, float data) {
		this.index = index;
		this.data = data;
	}

	public FeatureTuple() {
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}

	@Override
	public int compareTo(FeatureTuple o) {
		return this.index - o.index;
	}

	@Override
	public String toString() {
		return this.index + ":" + this.data + " ";
	}

	public static String listToString(List<FeatureTuple> features) {
		return features.stream().map(f -> String.format("%s:%s", f.getIndex(), f.getData()))
				.collect(Collectors.joining(" "));
	}
}
