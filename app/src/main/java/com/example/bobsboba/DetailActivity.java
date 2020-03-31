package com.example.bobsboba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
        setContentView(R.layout.activity_detail);

		try {
			wait(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		mCvBg = findViewById(R.id.cvBg);
		mFabBack = findViewById(R.id.fabBack);
		mFlIcon = findViewById(R.id.flIcon);


		YoYo.with(Techniques.SlideInUp).duration(500).playOn(mCvBg);

		YoYo.with(Techniques.RotateIn).duration(300).playOn(mFabBack);
		YoYo.with(Techniques.RotateIn).duration(300).playOn(mFlIcon);


        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
		int imageId = intent.getIntExtra(MainActivity.IMAGE_ID, 0);

        mStore = Store.getStores().get(position);
		getValues(position);



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
