package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class KalkulatorBata extends AppCompatActivity {
    Spinner spinner;
    String[] tebalbata = {"7,5", "10", "12,5", "15", "17,5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_bata);
        spinner=findViewById(R.id.spiner );

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(KalkulatorBata.this, R.layout.item_file,tebalbata);
        adapter.setDropDownViewResource(R.layout.item_file);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(KalkulatorBata.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}