package com.example.bobsboba;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class Store {
	private String name;
	private String topSeller;
	private String location;
	private double rating;
	private Integer logo;

	public Store() {
	}

	public Store(String name, String topSeller, String location, double rating, Integer logo) {
		this.name = name;
		this.topSeller = topSeller;
		this.location = location;
		this.rating = rating;
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopSeller() {
		return topSeller;
	}

	public void setTopSeller(String topSeller) {
		this.topSeller = topSeller;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Integer getLogo() {
		return logo;
	}

	public void setLogo(Integer logo) {
		this.logo = logo;
	}

	public static ArrayList<Integer> getLogos() {

		ArrayList<Integer> logoList = new ArrayList<Integer>();
		logoList.add(R.drawable.coco);
		logoList.add(R.drawable.sharetea);
		logoList.add(R.drawable.chatime);
		logoList.add(R.drawable.bengong);
		logoList.add(R.drawable.ts_express);
		logoList.add(R.drawable.bubble_nini);
		logoList.add(R.drawable.gongcha);
		logoList.add(R.drawable.machi_machi);
		logoList.add(R.drawable.king_tea);
		logoList.add(R.drawable.nofail);

		return logoList;
	}


	public static ArrayList<Store> getStores() {

		ArrayList<Store> stores = new ArrayList<>();

		stores.add(new Store("Coco", "Bubble Gaga", "Central", 4.9, getLogos().get(0)));
		stores.add(new Store("ShareTea", "Bubble Gaga", "Central", 4.9, getLogos().get(1)));
		stores.add(new Store("Chatime", "Bubble Gaga", "Central", 4.9, getLogos().get(2)));
		stores.add(new Store("Bengong", "Bubble Gaga", "Central", 4.9, getLogos().get(3)));
		stores.add(new Store("TS Express", "Bubble Gaga", "Central", 4.9, getLogos().get(4)));
		stores.add(new Store("Bubble Nini", "Bubble Gaga", "Central", 4.9, getLogos().get(5)));
		stores.add(new Store("Gong Cha", "Bubble Gaga", "Central", 4.9, getLogos().get(6)));
		stores.add(new Store("Machi Machi", "Bubble Gaga", "Central", 4.9, getLogos().get(7)));
		stores.add(new Store("King Tea", "Bubble Gaga", "Central", 4.9, getLogos().get(8)));
		stores.add(new Store("No Fail", "Bubble Gaga", "Central", 4.9, getLogos().get(9)));

		return stores;
	}
}
