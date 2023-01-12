package com.example.sitimit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class AdapterGalvalum extends RecyclerView.Adapter<AdapterGalvalum.HolderItem> {
    List<ModelGalvalum> mListItem;
    Context context;

    public AdapterGalvalum(List<ModelGalvalum> mListItem, Context context){
        this.mListItem = mListItem;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_layout_produk_list,parent,false);
        HolderItem holder = new HolderItem(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGalvalum.HolderItem holder, int position) {
        ModelGalvalum mList = mListItem.get(position);
        holder.nama_galvalum.setText(mList.getNama_galvalum());
        holder.harga_galvalum.setText(mList.getHarga_galvalum());



    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder{
        TextView nama_galvalum, harga_galvalum;

        public HolderItem (View v){
            super(v);
            nama_galvalum = (TextView) v.findViewById(R.id.nama_produk);
            harga_galvalum = (TextView) v.findViewById(R.id.harga_produk);

        }
    }
    void setFilter (ArrayList<ModelGalvalum> filterModel){
        mListItem = new ArrayList<>();
        mListItem.addAll(filterModel);
        notifyDataSetChanged();
    }

}

