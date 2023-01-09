package com.example.sitimit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProdukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdukFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProdukFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProdukFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProdukFragment newInstance(String param1, String param2) {
        ProdukFragment fragment = new ProdukFragment();
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
        View view = inflater.inflate(R.layout.fragment_produk, container, false);

        Button btnPanel = (Button)view.findViewById(R.id.buttonPanelLantai);
        Button btnSemen = (Button) view.findViewById(R.id.buttonMortar);
        Button btnBata = (Button) view.findViewById(R.id.buttonBataRingan);

        btnBata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBata();
            }
            public void btnBata(){
                Intent intent = new Intent(getActivity(), BataRingan.class);
                startActivity(intent);
            }
        });
        btnSemen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSemen();
            }
            public void btnSemen(){
                Intent intent = new Intent(getActivity(), semenMortar.class);
                startActivity(intent);
            }
        });
        btnPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPanel();
            }
            public void btnPanel(){
                Intent intent = new Intent(getActivity(), PanelLantai.class);
                startActivity(intent);
            }
        });
        return view;

    }
}