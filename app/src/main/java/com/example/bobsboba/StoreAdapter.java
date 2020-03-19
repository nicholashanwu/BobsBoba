package com.example.bobsboba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {
	private ArrayList<Store> mStores = new ArrayList<Store>(Store.getStores());
	private RecyclerViewClickListener mListener;

	public StoreAdapter(ArrayList<Store> stores, RecyclerViewClickListener listener) {
		mStores = stores;
		mListener = listener;
	}

	public interface RecyclerViewClickListener {
		void onClick(View view, int position);
	}

	public static class StoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {        //inner class CoinViewHolder that contains the content of each row
		public TextView name, topSeller, location, rating;
		public ImageView logo;
		private RecyclerViewClickListener mListener;

		public StoreViewHolder(View v, RecyclerViewClickListener listener) {                                     //constructor for the CoinViewHolder
			super(v);                                                                                           //the more TextViews required, the more stuff here
			mListener = listener;
			v.setOnClickListener(this);
			name = v.findViewById(R.id.txtName);
			topSeller = v.findViewById(R.id.txtTopSeller);
			location = v.findViewById(R.id.txtLocation);
			rating = v.findViewById(R.id.txtRating);
			logo = (ImageView) v.findViewById(R.id.ivRowLogo);
			//logo = v.findViewById(R.id.ivLogo);


		}

		@Override
		public void onClick(View view) {
			mListener.onClick(view, getAdapterPosition());

		}
	}

	@Override
	public StoreAdapter.StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
		return new StoreViewHolder(v, mListener);
	}

	@Override
	public void onBindViewHolder(StoreViewHolder holder, int position) {                                         //position determines the list item we are currently creating for the RecyclerView
		Store store = mStores.get(position);
		System.out.println(store);

		holder.name.setText(Store.getStores().get(position).getName());
		holder.topSeller.setText(Store.getStores().get(position).getTopSeller());
		holder.location.setText(Store.getStores().get(position).getLocation());
		holder.rating.setText(String.valueOf(store.getRating()));
		holder.logo.setImageResource(Store.getLogos().get(position));
	}

	@Override
	public int getItemCount() {
		return mStores.size();
	}
}
