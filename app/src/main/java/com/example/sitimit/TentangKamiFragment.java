package com.example.sitimit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TentangKamiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TentangKamiFragment extends Fragment {




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TentangKamiFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TentangKamiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TentangKamiFragment newInstance(String param1, String param2) {
        TentangKamiFragment fragment = new TentangKamiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tentang_kami, container, false);
        Button button = (Button) view.findViewById(R.id.buttonsby);
        Button btnmalang = (Button) view.findViewById(R.id.buttonmalang);
        Button btnfag = (Button) view.findViewById(R.id.buttonfaq);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsby();
            }

            private void buttonsby() {
                Intent intent = new Intent(getActivity(), tigamitrasurabaya.class);
                startActivity(intent);
            }

        });
        btnmalang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonmalang();
            }
            private void buttonmalang(){
                Intent intent = new Intent(getActivity(), tigamitramalang.class);
                startActivity(intent);
            }
        });
        btnfag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               buttonfag();
            }
            private void buttonfag(){
                Intent intent = new Intent(getActivity(), faq.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
