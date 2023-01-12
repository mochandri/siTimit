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
    public void buttonyt(View view) {
        String url = "https://www.youtube.com/@tigamitramalang";
        Intent yt = new Intent(Intent.ACTION_VIEW);
        yt.setData(Uri.parse(url));
        startActivity(yt);
    }
    public void buttonshop(View view) {
        String url = "https://shopee.co.id/tigamitramalang";
        Intent shop = new Intent(Intent.ACTION_VIEW);
        shop.setData(Uri.parse(url));
        startActivity(shop);
    }
    public void buttontok(View view) {
        String url = "https://www.tokopedia.com/tigamitramalang";
        Intent tok = new Intent(Intent.ACTION_VIEW);
        tok.setData(Uri.parse(url));
        startActivity(tok);
    }
    public void buttonig(View view) {
        String url = "https://www.instagram.com/tigamitramalang/";
        Intent ig = new Intent(Intent.ACTION_VIEW);
        ig.setData(Uri.parse(url));
        startActivity(ig);
    }
    public void buttonfb(View view) {
        String url = "https://www.facebook.com/3mitramalang";
        Intent fb = new Intent(Intent.ACTION_VIEW);
        fb.setData(Uri.parse(url));
        startActivity(fb);
    }
    public void buttontiktok(View view) {
        String url = "https://www.tiktok.com/@tigamitramalang?lang=id-ID";
        Intent tiktok = new Intent(Intent.ACTION_VIEW);
        tiktok.setData(Uri.parse(url));
        startActivity(tiktok);
    }
    public void buttonweb(View view) {
        String url = "https://www.tigamitramalang.co.id/";
        Intent web = new Intent(Intent.ACTION_VIEW);
        web.setData(Uri.parse(url));
        startActivity(web);
    }
    public void buttonmaps(View view) {
        String url = "https://www.google.com/maps/place/Tiga+Mitra+Malang+%7C+jual+bata+ringan,+panel+lantai,+semen+mortar/@-7.9543315,112.6325587,12z/data=!4m18!1m12!4m11!1m3!2m2!1d112.7022532!2d-7.9541615!1m6!1m2!1s0x2dd628f45768cc31:0xd4eb19156308d076!2sJl.+Raya+Pakis,+RT.01%2FRW.06,+Krajan,+Bunut+Wetan,+Kec.+Pakis,+Kabupaten+Malang,+Jawa+Timur+65154!2m2!1d112.7025993!2d-7.9543374!3m4!1s0x2dd628f45768cc31:0xd4eb19156308d076!8m2!3d-7.9543374!4d112.7025993";
        Intent web = new Intent(Intent.ACTION_VIEW);
        web.setData(Uri.parse(url));
        startActivity(web);
    }
}