package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Galeri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);
    }
    public void btnwa2(View view){
        String url="https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20Ada%20Yang%20Ingin%20Saya%20Tanyakan..";
        Intent bukawa = new Intent(Intent.ACTION_VIEW);
        bukawa.setData(Uri.parse(url));
        startActivity(bukawa);

    }

}