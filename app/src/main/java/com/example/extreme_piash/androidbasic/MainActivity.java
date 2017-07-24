package com.example.extreme_piash.androidbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.extreme_piash.androidbasic.core.ApplicationSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationSingleton.getInstance().getNetworkCallInterface().getApiData().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }
}
