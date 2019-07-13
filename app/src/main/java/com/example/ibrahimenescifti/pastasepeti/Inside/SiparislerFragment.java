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
public class SiparislerFragment extends android.app.Fragment {


    public SiparislerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_siparisler, container, false);;
        // Inflate the layout for this fragment
        return view;
    }

}
