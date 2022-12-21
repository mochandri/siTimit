package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KalkulatorPanelLantai extends AppCompatActivity {
    EditText p,l;
    TextView volume, luas;
    Button hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_panel_lantai);

        p = (EditText) findViewById(R.id.panjang);
        l = (EditText) findViewById(R.id.lebar);
        volume =(TextView) findViewById(R.id.twvolume);
        luas = (TextView) findViewById(R.id.twluas);
        hasil = (Button) findViewById(R.id.hasil);

        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p.length()==0 && l.length()==0){
                    Toast.makeText(getApplication(),"Panjang dan Lebar tidak boleh kosong",Toast.LENGTH_LONG).show();
                }
                else if (p.length()==0){
                    Toast.makeText(getApplication(),"Panjang Tidak Boleh Kosong",Toast.LENGTH_LONG).show();
                }
                else if (l.length()==0){
                    Toast.makeText(getApplication(),"Lebar Tidak Boleh Kosong",Toast.LENGTH_LONG).show();
            }
                else{
                    String isiPanjang = p.getText().toString();
                    String isiLebar = l.getText().toString();

                    Double p = Double.parseDouble(isiPanjang);
                    Double l = Double.parseDouble(isiLebar);

                    double hs = luasPanel (p,l);
                    double hv = volumePanel (p,l);

                    String outputt = String.valueOf(hv);
                    String output = String.valueOf(hs);
                    luas.setText(output.toString());
                    volume.setText(output.toString());

                }
            }
        });


        


    }
    public double luasPanel (double p, double l){
        return (p*l);
    }
    public double volumePanel (double p, double l) {
        return (p * l) / (8);
    }

}