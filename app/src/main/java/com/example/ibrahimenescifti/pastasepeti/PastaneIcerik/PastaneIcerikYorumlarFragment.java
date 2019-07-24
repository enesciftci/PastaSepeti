package com.example.ibrahimenescifti.pastasepeti.PastaneIcerik;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ibrahimenescifti.pastasepeti.Modeller.PastaneIcerikModel;
import com.example.ibrahimenescifti.pastasepeti.R;

import java.util.ArrayList;

public class PastaneIcerikYorumlarFragment extends Fragment {
    PastaneIcerikModel pastaneIcerikModel=new PastaneIcerikModel();
    public ListView pastaneIcerikYorumlarListView;
    public PastaneIcerikYorumlarFragment() {
        // Required empty public constructor
    }

    ArrayAdapter icerikAdapter;
    PastaneIcerik pastaneIcerik=new PastaneIcerik();
    ArrayList<String > icerikArray=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_pastane_icerik_yorumlar, container, false);
        // Inflate the layout for this fragment
       /* pastaneIcerikYorumlarListView= view.findViewById(R.id.pastaneIcerikYorumlarListView);
        try {

            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < PastaSepetiDAL.PastaneIcerikList.size(); i++) {
                ObjectMapper mapper = new ObjectMapper();
                pastaneIcerikModel = mapper.readValue(PastaSepetiDAL.PastaneIcerikList.get(i), PastaneIcerikModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        icerikAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, icerikArray);
        pastaneIcerikYorumlarListView.setAdapter(icerikAdapter);*/
        return view;
    }
}