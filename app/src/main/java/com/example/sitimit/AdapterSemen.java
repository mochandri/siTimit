package com.example.sitimit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class AdapterSemen extends RecyclerView.Adapter<AdapterSemen.HolderItem> {
    List<ModelSemen> mListItem;
    Context context;

    public AdapterSemen(List<ModelSemen> mListItem, Context context) {
        this.mListItem = mListItem;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rows, parent, false);
        HolderItem holder = new HolderItem(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderItem holder, int position) {
        ModelSemen mList = mListItem.get(position);
        holder.nama_semen.setText(mList.getNama_semen());
        holder.harga_semen.setText(mList.getHarga_semen());

        Glide.with(context).load(mList.getGambar_url()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView nama_semen, harga_semen;

        public HolderItem(View v) {
            super(v);
            thumbnail = (ImageView) v.findViewById(R.id.img_cover);
            nama_semen = (TextView) v.findViewById(R.id.nama);
            harga_semen = (TextView) v.findViewById(R.id.harga);
        }
    }
}
