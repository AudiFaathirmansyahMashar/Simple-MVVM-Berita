package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.models.Berita;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private Berita beritas;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView judul, waktu, kutipan;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            judul = itemView.findViewById(R.id.judul);
            waktu = itemView.findViewById(R.id.waktu);
            kutipan = itemView.findViewById(R.id.kutipan);
        }
    }

    public RecyclerViewAdapter(Context context, Berita beritas){
        this.context = context;
        this.beritas = beritas;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Berita berita = beritas;

        RequestOptions options = new RequestOptions().error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(berita.getData().get(position).getPoster())
                .into(holder.image);

        holder.judul.setText(berita.getData().get(position).getJudul());
        holder.kutipan.setText(berita.getData().get(position).getJudul());
        holder.waktu.setText(berita.getData().get(position).getWaktu());
    }

    @Override
    public int getItemCount() {
        return beritas.getData().size();
    }
}
