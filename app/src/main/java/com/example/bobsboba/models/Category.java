package com.example.bobsboba.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

	@SerializedName("categories")
	@Expose
	private com.example.bobsboba.models.Categories categories;

	public com.example.bobsboba.models.Categories getCategories() {
		return categories;
	}

	public void setCategories(com.example.bobsboba.models.Categories categories) {
		this.categories = categories;
	}
}
