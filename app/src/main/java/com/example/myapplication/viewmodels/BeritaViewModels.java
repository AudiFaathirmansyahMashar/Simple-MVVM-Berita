package com.example.myapplication.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.models.Berita;
import com.example.myapplication.repository.BeritaRepository;

public class BeritaViewModels extends ViewModel {
    private BeritaRepository repository;
    private MutableLiveData<Berita> data;

    public void init(){
        if (data != null) {
            data = null;
        }

        repository = BeritaRepository.getInstance();
        data = repository.getData();
    }

    public LiveData<Berita> getBerita(){
        return data;
    }
}
