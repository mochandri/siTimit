package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ArtikelEmpat extends AppCompatActivity {

    TextView textView;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_empat);

        textView = (TextView) findViewById(R.id.clickempat);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtikelEmpat.this, artikel.class);
                startActivity(intent);
            }
        });
        textView1 = (TextView) findViewById(R.id.clickbacajuga);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtikelEmpat.this, ArtikelLima.class);
                startActivity(intent);
            }
        });
        textView2 = (TextView) findViewById(R.id.clickbaca);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtikelEmpat.this, ArtikelTujuh.class);
                startActivity(intent);
            }
        });



    }
}