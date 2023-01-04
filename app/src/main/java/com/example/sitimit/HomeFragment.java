package com.example.sitimit;

import android.content.Intent;
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

//        Button button = (Button) view.findViewById(R.id.btnkategori);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Fragment fragment = new Fragment();
////                FragmentTransaction fm = getParentFragmentManager().beginTransaction();
////                fm.replace(R.id.kategori,fragment).commit();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                FragmentGreen llf = new FragmentGreen();
//                ft.replace(R.id.listFragment, llf);
//                ft.commit();
//            }
//        });
//    public View onClick(LayoutInflater inflater, ViewGroup container,
//                              Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        Button button = (Button) view.findViewById(R.id.btnkategori);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                btnKategori();
//            }
//
//            private void btnKategori() {
//                Intent intent = new Intent(getActivity(), ProdukFragment.class);
//                startActivity(intent);
//            }
//        });
//        return view;
//    }
//
//    ;


//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        dataInitialize();
//
//        recyclerView =view.findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setHasFixedSize(true);
//        Myadapter myadapter = new Myadapter(getContext(),newArraylist);
//        recyclerView.setAdapter(myadapter);
//        myadapter.notifyDataSetChanged();
//    }
//
//    private void dataInitialize() {
//
//        newArraylist = new ArrayList<>();
//
//        newHeading = new String[]{
//                getString(R.string.head_1),
//                getString(R.string.head_2),
//                getString(R.string.head_3),
//
//
//
//        };
//        imageResourceID = new int[]{
//                R.drawable.a_panel,
//                R.drawable.b_mortar,
//                R.drawable.c_bata,
//
//        };
//
//
//        for (int i=0;i<newHeading.length;i++){
//
//            News news = new News(newHeading[i],imageResourceID[i]);
//            newArraylist.add(news);
//        }
//    }







