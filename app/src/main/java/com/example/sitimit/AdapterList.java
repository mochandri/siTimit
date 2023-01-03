package com.example.sitimit;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        holder.deskripsi_bata.setText(mList.getDeskripsi_bata());
        Glide.with(context).load(mList.getGambar_url()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);
        holder.btnbeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wpurl="https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20saya%20ingin%20membeli%20bata%20ringan..";
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

    public class HolderItem extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView nama_bata, harga_bata, deskripsi_bata;
        Button btnbeli;

        public HolderItem (View v){
            super(v);
            thumbnail = (ImageView) v.findViewById(R.id.img_cover);
            nama_bata = (TextView) v.findViewById(R.id.nama);
            harga_bata = (TextView) v.findViewById(R.id.harga);
            deskripsi_bata = (TextView) v.findViewById(R.id.deskripsi);
            btnbeli = (Button) v.findViewById(R.id.btnBeli);
        }
    }

}
