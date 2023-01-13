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

public class AdapterBoard extends RecyclerView.Adapter<AdapterBoard.HolderItem> {
    List<ModelBoard> mListItem;
    Context context;

    public AdapterBoard(List<ModelBoard> mListItem, Context context){
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
    public void onBindViewHolder(@NonNull HolderItem holder, int position) {
        ModelBoard mList = mListItem.get(position);
        holder.nama_board.setText(mList.getNama_board());
        holder.harga_board.setText(mList.getHarga_board());



    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder{
        TextView nama_board, harga_board;

        public HolderItem (View v){
            super(v);
            nama_board = (TextView) v.findViewById(R.id.nama_produk);
            harga_board = (TextView) v.findViewById(R.id.harga_produk);

        }
    }
    void setFilter (ArrayList<ModelBoard> filterModel){
        mListItem = new ArrayList<>();
        mListItem.addAll(filterModel);
        notifyDataSetChanged();
    }

}

