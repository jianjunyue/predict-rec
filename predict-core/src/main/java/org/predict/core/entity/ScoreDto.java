package org.predict.core.entity;

import java.util.List;

public class ScoreDto {

	private int firstFoodCount = 100;
	private double firstFoodScore = 0.11;
	private int secondFoodCount = 80;
	private double secondFoodScore = 0.12;
	private int firstRestaurantCount = 1000;
	private double firstRestaurantScore = 0.22;
	private int secondRestaurantCount = 500;
	private double secondRestaurantScore = 0.33;
	private int userCount = 1000;
	private double userScore = 0.55;
	private List<Double> restaurantCondition;
	private List<Double> restaurantAmount;
	private List<Double> foodPrice;
	private int restaurantNum = 600;
	private int foodNum = 3000;
	private double nowPrice = 20;

	public int getFirstFoodCount() {
		return firstFoodCount;
	}

	public void setFirstFoodCount(int firstFoodCount) {
		this.firstFoodCount = firstFoodCount;
	}

	public double getFirstFoodScore() {
		return firstFoodScore;
	}

	public void setFirstFoodScore(double firstFoodScore) {
		this.firstFoodScore = firstFoodScore;
	}

	public int getSecondFoodCount() {
		return secondFoodCount;
	}

	public void setSecondFoodCount(int secondFoodCount) {
		this.secondFoodCount = secondFoodCount;
	}

	public double getSecondFoodScore() {
		return secondFoodScore;
	}

	public void setSecondFoodScore(double secondFoodScore) {
		this.secondFoodScore = secondFoodScore;
	}

	public int getFirstRestaurantCount() {
		return firstRestaurantCount;
	}

	public void setFirstRestaurantCount(int firstRestaurantCount) {
		this.firstRestaurantCount = firstRestaurantCount;
	}

	public double getFirstRestaurantScore() {
		return firstRestaurantScore;
	}

	public void setFirstRestaurantScore(double firstRestaurantScore) {
		this.firstRestaurantScore = firstRestaurantScore;
	}

	public int getSecondRestaurantCount() {
		return secondRestaurantCount;
	}

	public void setSecondRestaurantCount(int secondRestaurantCount) {
		this.secondRestaurantCount = secondRestaurantCount;
	}

	public double getSecondRestaurantScore() {
		return secondRestaurantScore;
	}

	public void setSecondRestaurantScore(double secondRestaurantScore) {
		this.secondRestaurantScore = secondRestaurantScore;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public double getUserScore() {
		return userScore;
	}

	public void setUserScore(double userScore) {
		this.userScore = userScore;
	}

	public List<Double> getRestaurantCondition() {
		return restaurantCondition;
	}

	public void setRestaurantCondition(List<Double> restaurantCondition) {
		this.restaurantCondition = restaurantCondition;
	}

	public List<Double> getRestaurantAmount() {
		return restaurantAmount;
	}

	public void setRestaurantAmount(List<Double> restaurantAmount) {
		this.restaurantAmount = restaurantAmount;
	}

	public List<Double> getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(List<Double> foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getRestaurantNum() {
		return restaurantNum;
	}

	public void setRestaurantNum(int restaurantNum) {
		this.restaurantNum = restaurantNum;
	}

	public int getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}

	public double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	@Override
	public String toString() {
		return "ScoreDto [firstFoodCount=" + firstFoodCount + ", firstFoodScore=" + firstFoodScore
				+ ", secondFoodCount=" + secondFoodCount + ", secondFoodScore=" + secondFoodScore
				+ ", firstRestaurantCount=" + firstRestaurantCount + ", firstRestaurantScore=" + firstRestaurantScore
				+ ", secondRestaurantCount=" + secondRestaurantCount + ", secondRestaurantScore="
				+ secondRestaurantScore + ", userCount=" + userCount + ", userScore=" + userScore
				+ ", restaurantCondition=" + restaurantCondition + ", restaurantAmount=" + restaurantAmount
				+ ", foodPrice=" + foodPrice + ", restaurantNum=" + restaurantNum + ", foodNum=" + foodNum
				+ ", nowPrice=" + nowPrice + "]";
	}

}