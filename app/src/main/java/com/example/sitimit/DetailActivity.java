package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txtid = findViewById(R.id.txtid);

        Bundle a =getIntent().getExtras();
        String b =(String) a.get("send_id");

        txtid.setText(b);
    }
}