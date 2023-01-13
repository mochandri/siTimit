package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ArtikelTiga extends AppCompatActivity {

    TextView textView, textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_tiga);

        textView = (TextView) findViewById(R.id.clicktiga);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ArtikelTiga.this, artikel.class);
                startActivity(intent);
            }
        });

        textView1 = (TextView) findViewById(R.id.artikeltiga);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ArtikelTiga.this, semenMortar.class);
                startActivity(intent);
            }
        });


    }
}