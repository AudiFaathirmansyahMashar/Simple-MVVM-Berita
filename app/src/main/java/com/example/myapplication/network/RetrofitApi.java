package com.example.myapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static RetrofitApi instance;

    public static RetrofitApi getInstance(){
        if (instance != null) {
            instance = null;
        }

        instance = new RetrofitApi();

        return instance;
    }

    public Retrofit getRetrofit(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
