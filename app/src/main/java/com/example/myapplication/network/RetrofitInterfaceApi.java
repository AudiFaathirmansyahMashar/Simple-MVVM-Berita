package com.example.myapplication.network;

import com.example.myapplication.models.Berita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterfaceApi {
    @GET("https://berita-news.herokuapp.com/")
    Call<Berita> getBerita();
}
