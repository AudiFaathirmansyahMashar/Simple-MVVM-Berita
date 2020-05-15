package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapters.RecyclerViewAdapter;
import com.example.myapplication.models.Berita;
import com.example.myapplication.viewmodels.BeritaViewModels;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private BeritaViewModels viewModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        viewModels = new ViewModelProvider(this).get(BeritaViewModels.class);
        viewModels.init();
        viewModels.getBerita().observe(this, new Observer<Berita>() {
            @Override
            public void onChanged(Berita berita) {
                adapter = new RecyclerViewAdapter(MainActivity.this, berita);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
