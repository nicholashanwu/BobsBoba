package com.example.bobsboba.responses;

import com.example.bobsboba.models.Category;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

	@SerializedName("categories")
	@Expose
	private List<Category> categories = null;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
