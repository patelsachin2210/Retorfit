package com.example.retorfit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String base_url = "https://api.github.com/users/";

    @GET("akashsarkar188")
    Call<ProfileDetails> getProfileDetails();
}
