package com.example.sitimit;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sitimit.databinding.FragmentHomeBinding;

import java.util.ArrayList;



public class HomeFragment extends Fragment {
    ImageSlider imageSlider;
    Button btnkategori;
    FragmentHomeBinding binding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);


    }

    private void setContentView(int fragment_home) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.image_slider);


        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.kantor, null));
        imageList.add(new SlideModel(R.drawable.no2, null));
        imageList.add(new SlideModel(R.drawable.no3, null));
        imageList.add(new SlideModel(R.drawable.no4, null));
        imageList.add(new SlideModel(R.drawable.no5, null));
        imageSlider.setImageList(imageList);


        Button button = (Button) view.findViewById(R.id.btnkategori);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment produk = new ProdukFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.kategori,produk).commit();
            }
        });
        return view;

    



    }


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
}






