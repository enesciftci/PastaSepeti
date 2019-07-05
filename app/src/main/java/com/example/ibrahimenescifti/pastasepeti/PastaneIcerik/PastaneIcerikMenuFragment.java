package com.example.ibrahimenescifti.pastasepeti.PastaneIcerik;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ibrahimenescifti.pastasepeti.R;

public class PastaneIcerikMenuFragment extends Fragment {

    public PastaneIcerikMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pastane_icerik_menu, container, false);
    }
}