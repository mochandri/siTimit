package com.example.sitimit;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sitimit.databinding.FragmentHomeBinding;
//import com.example.sitimit.retrofit.Myadapter;


import java.util.ArrayList;



public class HomeFragment extends Fragment {
    ImageSlider imageSlider;
    FragmentHomeBinding binding;
    ImageButton imageButton;
    Button back;

//    private ArrayList<News> newArraylist;
    private String[] newHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        ImageButton imgbtn1 = (ImageButton)view.findViewById(R.id.imgbtn1);
        ImageButton imgbtn2 = (ImageButton)view.findViewById(R.id.imgbtn2);
        ImageButton imgbtn3 = (ImageButton)view.findViewById(R.id.imgbtn3);
        ImageButton imgbtn_bata = (ImageButton)view.findViewById(R.id.imgbtn_bata);
        ImageButton imgbtn_dua = (ImageButton)view.findViewById(R.id.imgbtn_dua);
        ImageButton imgbtn_tiga = (ImageButton)view.findViewById(R.id.imgbtn_tiga);
        ImageButton imgbtn_empat = (ImageButton)view.findViewById(R.id.imgbtn_empat);
        ImageButton imgbtn_lima = (ImageButton)view.findViewById(R.id.imgbtn_lima);
        ImageButton imgbtn_enam = (ImageButton)view.findViewById(R.id.imgbtn_enam);
        ImageButton imgbtn_tujuh = (ImageButton)view.findViewById(R.id.imgbtn_tujuh);
        ImageButton imgbtn_delapan = (ImageButton)view.findViewById(R.id.imgbtn_delapan);
        ImageButton imgbtn_sembilan = (ImageButton)view.findViewById(R.id.imgbtn_sembilan);
        ImageButton imgbtn_sepuluh = (ImageButton)view.findViewById(R.id.imgbtn_sepuluh);
        ImageButton imgbtn_sebelas = (ImageButton)view.findViewById(R.id.imgbtn_sebelas);
        ImageButton imgbtn_duabelas = (ImageButton)view.findViewById(R.id.imgbtn_duabelas);
        ImageButton imgbtn_tigabelas = (ImageButton)view.findViewById(R.id.imgbtn_tigabelas);

        imgbtn_bata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/jual-bata-ringan/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/tips-dan-cara-menghitung-kebutuhan-panel-lantai//";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/apakah-semen-mortar-hanya-untuk-bata-ringan/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_empat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/3-aspek-penting-sebelum-membangun-rumah/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_lima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/tips-memilih-material-bangunan/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_enam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/tips-memilih-bata-ringan/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_tujuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/tips-membangun-rumah-low-budget/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_delapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/perbandingan-panel-lantai-dak-konvensional-dak-keraton/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_sembilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/pentingnya-menggunakan-galvalum/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_sepuluh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/kenapa-pembelian-bata-ringan-harus-108m3/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_sebelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/ini-7-kelebihan-pakai-bata-ringan/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_duabelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/cara-memasang-bata-ringan-yang-benar/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        imgbtn_tigabelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="https://tigamitrasurabaya.co.id/tips-pilih-bata-ringan-untuk-rumah-impian/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });




        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgbtn1();
            }
            public void imgbtn1(){
                Intent intent = new Intent(getActivity(), semenMortar.class);
                startActivity(intent);
            }
        });

        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgbtn2();
            }
            public void imgbtn2(){
                Intent intent = new Intent(getActivity(), BataRingan.class);
                startActivity(intent);
            }
        });

        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgbtn3();
            }
            public void imgbtn3(){
                Intent intent = new Intent(getActivity(), PanelLantai.class);
                startActivity(intent);
            }
        });


        imageSlider = view.findViewById(R.id.image_slider);


        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.kantor, null));
        imageList.add(new SlideModel(R.drawable.no2, null));
        imageList.add(new SlideModel(R.drawable.no3, null));
        imageList.add(new SlideModel(R.drawable.no4, null));
        imageList.add(new SlideModel(R.drawable.no5, null));
        imageSlider.setImageList(imageList);

        return view;


    }

    }









