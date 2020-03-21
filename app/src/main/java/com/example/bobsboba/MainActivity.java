package com.example.bobsboba;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bobsboba.interfaces.Service;
import com.example.bobsboba.responses.CategoryResponse;
import com.example.bobsboba.responses.SearchResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

	private Service mService;

	public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3634.beers.MESSAGE";

	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SessionConfig sessionConfig = new SessionConfig.Builder()
				.setApiKey("ac9d7ebd08cfe5d5bf2cd99346afc29f")
				.build(getApplicationContext());
		mService = ZomatoApi.with(sessionConfig).build(getApplicationContext()).createService();

		getAllCategories();


		mRecyclerView = findViewById(R.id.rvList);
		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);

		StoreAdapter.RecyclerViewClickListener listener = new StoreAdapter.RecyclerViewClickListener() {
			@Override
			public void onClick(View view, int position) {
				launchDetailActivity(position);
			}
		};

		mAdapter = new StoreAdapter(Store.getStores(), listener);
		mRecyclerView.setAdapter(mAdapter);
	}

	private void launchDetailActivity(int position) {
		Intent intent = new Intent(this, DetailActivity.class);
		intent.putExtra(EXTRA_MESSAGE, position);
		startActivity(intent);
	}

	public void getAllCategories() {

		HashMap<String, String> queryParamsMap = new HashMap<>();

		queryParamsMap.put("q", "dum");
		mService.search(queryParamsMap).enqueue(new Callback<SearchResponse>() {
			@Override
			public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
				//Toast.makeText(MainActivity.this,"success: "+response.body().
				//		getRestaurants().get(0).getRestaurant()
				//		.getName(),Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onFailure(Call<SearchResponse> call, Throwable t) {

				Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();


			}
		});

		mService.getAllCategories().enqueue(new Callback<CategoryResponse>() {
			@Override
			public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
				Log.i("Check1", response.body().getCategories().get(1).getCategories().getName());
				Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onFailure(Call<CategoryResponse> call, Throwable t) {

				Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

			}
		});

	}


}
