package com.example.sitimit;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
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
    FragmentHomeBinding binding;
    Button back;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        back = view.findViewById(R.id.btnkategori);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment kategori = new ProdukFragment();
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.kategori,kategori);
                fm.addToBackStack(null);
                fm.remove(kategori).commit();
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






