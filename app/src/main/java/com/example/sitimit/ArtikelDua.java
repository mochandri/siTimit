package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ArtikelDua extends AppCompatActivity {

    TextView textView, textView1;
    EditText p,l;
    TextView volume, luas;
    Button hasildua;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_dua);

        p = (EditText) findViewById(R.id.panjang);
        l = (EditText) findViewById(R.id.lebar);
        volume = (TextView) findViewById(R.id.twvolume);
        luas = (TextView) findViewById(R.id.twluas);
        hasildua = (Button) findViewById(R.id.hasildua);

        hasildua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.length() == 0 && l.length() == 0) {
                    Toast.makeText(getApplication(), "Panjang dan Lebar tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else if (p.length() == 0) {
                    Toast.makeText(getApplication(), "Panjang Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                } else if (l.length() == 0) {
                    Toast.makeText(getApplication(), "Lebar Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                } else {
                    String isiPanjang = p.getText().toString();
                    String isiLebar = l.getText().toString();

                    Double p = Double.parseDouble(isiPanjang);
                    Double l = Double.parseDouble(isiLebar);

                    double hs = luasPanel(p, l);
                    double hv = volumePanel(p, l);

                    String outputt = String.valueOf(hv);
                    String output = String.valueOf(hs);
                    luas.setText(output.toString());
                    volume.setText(outputt.toString());

                }
            }
        });

        textView = (TextView) findViewById(R.id.clickdua);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ArtikelDua.this, artikel.class);
                startActivity(intent);
            }
        });
        textView1 = (TextView) findViewById(R.id.clickhubungi);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl = "https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20Ada%20Yang%20Ingin%20Saya%20Tanyakan..";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
    }

        public double luasPanel (double p, double l){
            return (p*l);
        }
        public double volumePanel (double p, double l) {
            return (p*l)/8;
        }


    }