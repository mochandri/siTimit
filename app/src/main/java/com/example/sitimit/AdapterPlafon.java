package com.example.sitimit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPlafon extends  RecyclerView.Adapter<AdapterPlafon.HolderItem> {
    List<ModelPlafon> mListItem;
    Context context;

    public AdapterPlafon(List<ModelPlafon>mListItem,Context context){
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

//    @Override
//    public void onBindViewHolder(@NonNull HolderItem holder, int position) {
//
//    }

    @Override
    public void onBindViewHolder(@NonNull HolderItem holder, int position) {
        ModelPlafon mList = mListItem.get(position);
        holder.nama_plafon.setText(mList.getNama_plafon());
        holder.harga_plafon.setText(mList.getHarga_plafon());
//        holder.btnbeli.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String wpurl="https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20saya%20ingin%20membeli%20panel%20lantai..";
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(wpurl));
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }
    public class HolderItem extends RecyclerView.ViewHolder{
        TextView nama_plafon, harga_plafon;

        public HolderItem (View v){
            super(v);

            nama_plafon = (TextView) v.findViewById(R.id.nama_produk);
            harga_plafon = (TextView) v.findViewById(R.id.harga_produk);

        }
    }
    void setFilter (ArrayList<ModelPlafon> filterModel){
        mListItem = new ArrayList<>();
        mListItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
