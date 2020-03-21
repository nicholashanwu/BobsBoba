package com.example.bobsboba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private Store mStore;
    private TextView mName;
    private TextView mTopSeller;
    private TextView mLocation;
    private TextView mRating;
    private ImageView mLogo;
    private ImageView mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
        int coinSymbol = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        getValues(coinSymbol);

        mStore = Store.getStores().get(position);

    }

    private void getValues(int indexInt) {
        ArrayList<Store> storeList = new ArrayList<>(Store.getStores());

        mName = findViewById(R.id.txtName);
        mTopSeller = findViewById(R.id.txtTopSeller);
        mLocation = findViewById(R.id.txtLocation);
        mRating = findViewById(R.id.txtRating);
        mLogo = findViewById(R.id.ivLogo);

        mName.setText(storeList.get(indexInt).getName());
        mTopSeller.setText(storeList.get(indexInt).getTopSeller());
        mLocation.setText(storeList.get(indexInt).getLocation());
        mRating.setText(String.valueOf(storeList.get(indexInt).getRating()));
        mLogo.setImageResource(Store.getLogos().get(indexInt));

    }

    private void searchCoin(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }


}
