package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class artikel extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);

        button = (Button) findViewById(R.id.btn_satuartikel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(artikel.this, ArtikelSatu.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.btn_duaartikel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(artikel.this, ArtikelDua.class);
                startActivity(intent);
            }
        });



    }
}