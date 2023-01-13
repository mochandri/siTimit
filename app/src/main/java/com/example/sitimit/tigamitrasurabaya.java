package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class tigamitrasurabaya extends AppCompatActivity {

//    WebView vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigamitrasurabaya);

//        vid=(WebView) findViewById(R.id.video);
//        vid.loadUrl("file:///android_asset/iframyoutube.html");
//        vid.getSettings().setJavaScriptEnabled(true);
    }
    public void btnwa(View view){
        String url="https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20Ada%20Yang%20Ingin%20Saya%20Tanyakan..";
        Intent bukawa = new Intent(Intent.ACTION_VIEW);
        bukawa.setData(Uri.parse(url));
        startActivity(bukawa);

    }
    public void buttonyt(View view) {
        String url = "https://www.youtube.com/@tigamitra";
        Intent yt = new Intent(Intent.ACTION_VIEW);
        yt.setData(Uri.parse(url));
        startActivity(yt);
    }
    public void buttonshop(View view) {
        String url = "https://shopee.co.id/tigamitrasurabaya";
        Intent shop = new Intent(Intent.ACTION_VIEW);
        shop.setData(Uri.parse(url));
        startActivity(shop);
    }
    public void buttontok(View view) {
        String url = "https://www.tokopedia.com/tigamitrasurabaya";
        Intent tok = new Intent(Intent.ACTION_VIEW);
        tok.setData(Uri.parse(url));
        startActivity(tok);
    }

    public void buttonfb(View view) {
        String url = "https://web.facebook.com/3mitrasurabayapt";
        Intent fb = new Intent(Intent.ACTION_VIEW);
        fb.setData(Uri.parse(url));
        startActivity(fb);
    }
    public void buttontiktok(View view) {
        String url = "https://www.tiktok.com/@3mitrasurabaya?lang=id-ID";
        Intent tiktok = new Intent(Intent.ACTION_VIEW);
        tiktok.setData(Uri.parse(url));
        startActivity(tiktok);
    }
    public void buttonweb(View view) {
        String url = "https://www.tigamitra.co.id/";
        Intent web = new Intent(Intent.ACTION_VIEW);
        web.setData(Uri.parse(url));
        startActivity(web);
    }
    public void buttonmaps(View view) {
        String url = "https://www.google.com/maps/place/PT.+Tiga+Mitra+Surabaya+%7C+Jual+Bata+Ringan,+Semen+Mortar+dan+Panel+Lantai/@-7.2586923,112.6469297,16z/data=!4m19!1m13!4m12!1m4!2m2!1d112.6556212!2d-7.2614166!4e1!1m6!1m2!1s0x2dd7fe6a25a9032d:0xd10567b2b00803b5!2sPt.+Tiga+Mitra+Surabaya!2m2!1d112.6484394!2d-7.2554872!3m4!1s0x2dd7fe6a25a9032d:0xd10567b2b00803b5!8m2!3d-7.2554872!4d112.6484394";
        Intent web = new Intent(Intent.ACTION_VIEW);
        web.setData(Uri.parse(url));
        startActivity(web);
    }
}