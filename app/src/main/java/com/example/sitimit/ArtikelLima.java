package com.example.sitimit;

import static com.example.sitimit.R.id.clicklima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ArtikelLima extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_lima);

        textView = (TextView) findViewById(R.id.clicklima);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtikelLima.this, artikel.class);
                startActivity(intent);
            }
        });
    }
}