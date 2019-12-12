package org.predict.test.guava;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.protostuff.Tag;

public class ShopInfo {


	@JsonProperty("shop_id")
//    @Tag(1)
    private long shopId;

    @JsonProperty("restaurant_name")
//    @Tag(2)
    private String name;

    @JsonProperty("city_id")
//    @Tag(3)
    private int cityId;
    
    
    public long getShopId() {
		return shopId;
	}



	public void setShopId(long shopId) {
		this.shopId = shopId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCityId() {
		return cityId;
	}



	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


    
    
    @Override
    public String toString() {
        return "ShopInfo{" +
                "shopId=" + shopId +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
