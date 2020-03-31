package com.example.bobsboba;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private Store mStore;
    private TextView mName;
    private TextView mTopSeller;
    private TextView mLocation;
    private TextView mRating;
    private ImageView mLogo;
    private ImageView mSearch;
	private CardView mCvBg;
	private FloatingActionButton mFabBack;
	private FrameLayout mFlIcon;
	private ImageButton mBtnBack;
	private ImageButton mBtnSearch;
	private TextView mTxtTopSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
        setContentView(R.layout.activity_detail);

        mCvBg = findViewById(R.id.cvBg);
        mFlIcon = findViewById(R.id.flIcon);
        mBtnBack = findViewById(R.id.btnBack);
        mBtnSearch = findViewById(R.id.btnSearch);
        mTxtTopSeller = findViewById(R.id.txtTopSeller);

        mCvBg.setVisibility(View.GONE);
        YoYo.with(Techniques.BounceInUp).duration(1500).delay(100).playOn(mCvBg);
        mCvBg.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        final int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
		int imageId = intent.getIntExtra(MainActivity.IMAGE_ID, 0);

		mTxtTopSeller.setText("They are known for their " + mTxtTopSeller.getText() + ".");

        mStore = Store.getStores().get(position);
		getValues(position);

		mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

		mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchCoin(Store.getStores().get(position).getName());
            }
        });

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
