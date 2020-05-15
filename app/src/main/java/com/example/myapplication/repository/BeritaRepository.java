package com.example.myapplication.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.models.Berita;
import com.example.myapplication.network.RetrofitApi;
import com.example.myapplication.network.RetrofitInterfaceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeritaRepository {
    private static BeritaRepository instance;

    public static BeritaRepository getInstance() {
        if (instance != null) {
            instance = null;
        }

        instance = new BeritaRepository();

        return instance;
    }

    public MutableLiveData<Berita> getData(){
        final MutableLiveData<Berita> data = new MutableLiveData<>();

        RetrofitInterfaceApi api = RetrofitApi.getInstance().getRetrofit("https://berita-news.herokuapp.com/").create(RetrofitInterfaceApi.class);

        Call<Berita> call = api.getBerita();

        call.enqueue(new Callback<Berita>() {
            @Override
            public void onResponse(Call<Berita> call, Response<Berita> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Berita> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

        return data;
    }
}
