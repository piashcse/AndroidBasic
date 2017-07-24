package com.example.extreme_piash.androidbasic.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Extreme_Piash on 1/4/2017.
 */

public interface NetworkCallInterface {

    @GET("www.google.com")
    Call<List<String>> getApiData();
}