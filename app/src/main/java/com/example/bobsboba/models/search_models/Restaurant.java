package com.example.bobsboba.models.search_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

	@SerializedName("restaurant")
	@Expose
	private com.example.bobsboba.models.search_models.Restaurant_ restaurant;

	public com.example.bobsboba.models.search_models.Restaurant_ getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(com.example.bobsboba.models.search_models.Restaurant_ restaurant) {
		this.restaurant = restaurant;
	}
}
