package com.example.ibrahimenescifti.pastasepeti.Inside;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ibrahimenescifti.pastasepeti.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnasayfaFragment extends android.app.Fragment{


    public AnasayfaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_anasayfa, container, false);
    }

}
