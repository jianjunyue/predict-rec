package org.predict.core.entity;

public class ActivityDto {

	private long id;

	private double score;

	private int type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ActivityDto [id=" + id + ", score=" + score + ", type=" + type + "]";
	}

}
