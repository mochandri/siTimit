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

public class AdapterList extends RecyclerView.Adapter<AdapterList.HolderItem> {
    List<ModelList> mListItem;
    Context context;

    public AdapterList(List<ModelList> mListItem, Context context){
        this.mListItem = mListItem;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rows,parent,false);
        HolderItem holder = new HolderItem(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderItem holder, int position) {
        ModelList mList = mListItem.get(position);
        holder.nama_bata.setText(mList.getNama_bata());
        holder.harga_bata.setText(mList.getHarga_bata());

        Glide.with(context).load(mList.getGambar_url()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView nama_bata, harga_bata;

        public HolderItem (View v){
            super(v);
            thumbnail = (ImageView) v.findViewById(R.id.img_cover);
            nama_bata = (TextView) v.findViewById(R.id.nama);
            harga_bata = (TextView) v.findViewById(R.id.harga);
        }
    }
}
