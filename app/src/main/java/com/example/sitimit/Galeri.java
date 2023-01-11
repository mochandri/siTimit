package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Galeri extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);

        textView = (TextView) findViewById(R.id.txt_viewimg);
        textView = (TextView) findViewById(R.id.txt_viewimgbata);

        Button btnulasan = (Button) findViewById(R.id.btnulasan);
        btnulasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://tokobataringan.com/";
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(url));
                startActivity(web);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Galeri.this,GaleriBata.class);
                startActivity(intent);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Galeri.this,GaleriPanel.class);
                startActivity(intent);
            }
        });
    }
}