package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class tigamitramalang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigamitramalang);
    }
    public void btnwa(View view){
        String url="https://api.whatsapp.com/send?phone=082132137447&text=Halo%20Bapak%20Taufik%20Tiga%20Mitra%20Malang,%20Saya%20Mau%20Bertanya%20Tentang%20Material%20Bangunan";
        Intent bukawa = new Intent(Intent.ACTION_VIEW);
        bukawa.setData(Uri.parse(url));
        startActivity(bukawa);

    }
}