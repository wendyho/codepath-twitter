package com.codepath.apps.restclienttemplate;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.AsyncHttpClient;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class TweetDetail extends AppCompatActivity {

    Tweet tweet;
    TextView tvUserDetail;
    TextView tvBodyDetail;
    ImageView ivProfileDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_detail);

        tvUserDetail = (TextView) findViewById(R.id.tvUserDetail);
        tvBodyDetail = (TextView) findViewById(R.id.tvBodyDetail);
        ivProfileDetail = (ImageView) findViewById(R.id.ivProfileDetail);

        // unwrap the movie passed in via intent, using its simple name asa  key
        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));

        // set the title and overview
        tvUserDetail.setText(tweet.user.name);
        tvBodyDetail.setText(tweet.body);


        Glide.with(this)
                .load(tweet.user.profileImageUrl)
                .bitmapTransform(new RoundedCornersTransformation(this, 100, 0))
                .into(ivProfileDetail);
    }
}
