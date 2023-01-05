package com.example.sitimit;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


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

        imgbtn_bata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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









