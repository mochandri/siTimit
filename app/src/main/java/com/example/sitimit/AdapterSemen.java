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
        holder.deskripsi_semen.setText(mList.getDeskripsi_semen());

        Glide.with(context).load(mList.getGambar_url()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);
        holder.btnbeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wpurl="https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20saya%20ingin%20membeli%20semenn%20mortar..";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView nama_semen, harga_semen, deskripsi_semen, btnbeli;

        public HolderItem(View v) {
            super(v);
            thumbnail = (ImageView) v.findViewById(R.id.img_cover);
            nama_semen = (TextView) v.findViewById(R.id.nama);
            harga_semen = (TextView) v.findViewById(R.id.harga);
            deskripsi_semen = (TextView) v.findViewById(R.id.deskripsi);
            btnbeli = (Button) v.findViewById(R.id.btnBeli);
        }
    }
}
