package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class tigamitrasurabaya extends AppCompatActivity {

    WebView vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tigamitrasurabaya);

        vid=(WebView) findViewById(R.id.video);
        vid.loadUrl("file:///android_asset/iframyoutube.html");
        vid.getSettings().setJavaScriptEnabled(true);
    }
    public void btnwa(View view){
        String url="https://wa.me/6281231313222";
        Intent bukawa = new Intent(Intent.ACTION_VIEW);
        bukawa.setData(Uri.parse(url));
        startActivity(bukawa);

    }
}