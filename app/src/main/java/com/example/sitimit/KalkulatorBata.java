package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class KalkulatorBata extends AppCompatActivity {
    Spinner spinner;
    String[] tebalbata = {"7,5 cm", "10 cm"};
    EditText panjang, lebar, tinggi;
    Button hasil;
    TextView jumlah, luass;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_bata);
        spinner=findViewById(R.id.spiner );
        panjang = (EditText) findViewById(R.id.panjang);
        lebar = (EditText) findViewById(R.id.lebar);
        tinggi = (EditText) findViewById(R.id.tinggi);
        hasil = (Button) findViewById(R.id.hasil);
        jumlah = (TextView)findViewById(R.id.jumlahbata);
        luass = (TextView)findViewById(R.id.jumlahkebutuhan);

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

        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panjang.length()==0 && lebar.length()==0 && tinggi.length()==0){
                    Toast.makeText(getApplication(),"Panjang ,Lebar dan tinggi tidak boleh kosong",Toast.LENGTH_LONG).show();
                }
                else if (panjang.length()==0){
                    Toast.makeText(getApplication(),"Panjang Tidak Boleh Kosong",Toast.LENGTH_LONG).show();
                }
                else if (lebar.length()==0){
                    Toast.makeText(getApplication(),"Lebar Tidak Boleh Kosong",Toast.LENGTH_LONG).show();
                }
                else if (tinggi.length()==0){
                    Toast.makeText(getApplication(),"Tinggi Tidak Boleh Kosong",Toast.LENGTH_LONG).show();
                }
                else if (spinner.getSelectedItem().toString().equals("7,5 cm")){
                    String isiLebar = lebar.getText().toString();
                    String isiPanjang = panjang.getText().toString();
                    String isiTinggi = tinggi.getText().toString();

                    Double panjang = Double.parseDouble(isiPanjang);
                    Double lebar = Double.parseDouble(isiLebar);
                    Double tinggi = Double.parseDouble(isiTinggi);
                    Double hasilkebutuhan = (2* panjang + 2*lebar )*tinggi / 7.5;
                    Double hasilluas = hasilkebutuhan * 111  ;
                    jumlah.setText(hasilluas.toString());
                    luass.setText(hasilkebutuhan.toString());


                }else if (spinner.getSelectedItem().toString().equals("10 cm")){
                    String isiLebar = lebar.getText().toString();
                    String isiPanjang = panjang.getText().toString();
                    String isiTinggi = tinggi.getText().toString();

                    Double panjang = Double.parseDouble(isiPanjang);
                    Double lebar = Double.parseDouble(isiLebar);
                    Double tinggi = Double.parseDouble(isiTinggi);
                    Double hasilkebutuhan = (2* panjang + 2*lebar )*tinggi / 10;
                    Double hasilluas = hasilkebutuhan * 83  ;
                    jumlah.setText(hasilluas.toString());
                    luass.setText(hasilkebutuhan.toString());


                }

//                if(spinner.getSelectedItem().toString().equals("7,5")){
//                    String isiPanjang = panjang.getText().toString();
//                    String isiLebar = lebar.getText().toString();
//                    String isiTinggi = tinggi.getText().toString();
//
//                    Double panjang = Double.parseDouble(isiPanjang);
//                    Double lebar = Double.parseDouble(isiLebar);
//                    Double tinggi = Double.parseDouble(isiTinggi);
//                    double hv = kebutuhanBata (panjang,lebar,tinggi);
//                    String kebutuhan = String.valueOf(hv);
//                    jumlah.setText(kebutuhan.toString());
                }

            });

        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20Ada%20Yang%20Ingin%20Saya%20Tanyakan..";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        }
    }

//    public  double luasBangunan (double panjang, double lebar, double tinggi){
//        return ((2* panjang)+ (2*lebar)*tinggi);
//    }
//    public  double kebutuhanBata (double panjang, double lebar, double tinggi){
//        return (2*(panjang + lebar) * tinggi);
//    }
