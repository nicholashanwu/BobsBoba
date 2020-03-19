package com.example.bobsboba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3634.beers.MESSAGE";

	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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


}
