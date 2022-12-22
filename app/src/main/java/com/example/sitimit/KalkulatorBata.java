package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class KalkulatorBata extends AppCompatActivity {
    Spinner spinner;
    String[] tebalbata = {"7,5", "10", "12,5", "15", "17,5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_bata);
        spinner=findViewById(R.id.spiner );

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(KalkulatorBata.this, android.R.layout.simple_spinner_item,tebalbata);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
}