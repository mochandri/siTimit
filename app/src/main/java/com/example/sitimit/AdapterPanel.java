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

public class AdapterPanel extends RecyclerView.Adapter<AdapterPanel.HolderItem> {
    List<ModelPanel> mListItem;
    Context context;

    public AdapterPanel(List<ModelPanel>mListItem,Context context){
        this.mListItem = mListItem;
        this.context = context;
    }
    @NonNull
    @Override
    public HolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_panel,parent,false);
        HolderItem holder = new HolderItem(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderItem holder, int position) {
        ModelPanel mList = mListItem.get(position);
        holder.nama_panel.setText(mList.getNama_panel());
        holder.harga_panel.setText(mList.getHarga_panel());
        holder.deskripsi_panel.setText(mList.getDeskripsi_panel());

        Glide.with(context).load(mList.getGambar_url()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail);
        holder.btnbeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wpurl="https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20saya%20ingin%20membeli%20panel%20lantai..";
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
        TextView nama_panel, harga_panel,deskripsi_panel,btnbeli;

        public HolderItem (View v){
            super(v);
            thumbnail = (ImageView) v.findViewById(R.id.img_cover);
            nama_panel = (TextView) v.findViewById(R.id.nama);
            harga_panel = (TextView) v.findViewById(R.id.harga);
            deskripsi_panel =(TextView) v.findViewById(R.id.deskripsi);
            btnbeli = (Button) v.findViewById(R.id.btnBeli);
        }
    }
    void setFilter (ArrayList<ModelPanel> filterModel){
        mListItem = new ArrayList<>();
        mListItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
