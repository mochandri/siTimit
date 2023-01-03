package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textNama, textDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().hide();

        imageView =(ImageView) findViewById(R.id.imgDeskripsi);
        textNama = (TextView) findViewById(R.id.txt_nama);
        textDeskripsi = (TextView) findViewById(R.id.txt_deskripsi);

        Intent intent = getIntent();
        String nama_bata = intent.getExtras().getString("nama_bata");
        String deskripsi_bata = intent.getExtras().getString("deskripsi_bata");
        String gambar_url = intent.getExtras().getString("gambar_url");

        imageView.setImageResource(Integer.parseInt(gambar_url));
        textNama.setText(nama_bata);
        textDeskripsi.setText(deskripsi_bata);
    }
}