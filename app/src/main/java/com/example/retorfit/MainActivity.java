package com.example.retorfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(Api.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Api api = retrofit.create(Api.class);

        Call<ProfileDetails> profileDetailsCall = api.getProfileDetails();

        profileDetailsCall.enqueue(new Callback<ProfileDetails>() {
            @Override
            public void onResponse(Call<ProfileDetails> call, Response<ProfileDetails> response) {
                ProfileDetails profileDetails = response.body();
                Log.d(TAG, "onResponse: ProfileDetails : " + profileDetails.getLogin());
                Log.d(TAG, "onResponse: ProfileDetails : " + profileDetails.getBio());
                Log.d(TAG, "onResponse: ProfileDetails : " + profileDetails.getFollowers());
                Log.d(TAG, "onResponse: ProfileDetails : " + profileDetails.getFollowing());

            }

            @Override
            public void onFailure(Call<ProfileDetails> call, Throwable t) {
                Log.d(TAG, "onFailure: ProfileDetails :" + t.getMessage());
            }
        });

    }


}
