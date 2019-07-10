package com.example.ibrahimenescifti.pastasepeti.Inside;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiDAL;
import com.example.ibrahimenescifti.pastasepeti.Modeller.PastaneBilgileriModel;
import com.example.ibrahimenescifti.pastasepeti.PastaneIcerik.PastaneIcerik;
import com.example.ibrahimenescifti.pastasepeti.R;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastanelerFragment extends android.app.Fragment {

    public PastanelerFragment() {
        // Required empty public constructor
    }
    ListView pastanelerListview;
    ArrayAdapter<String> pastanelerAdapter;
    PastaneBilgileriModel pastaneBilgileriModel = new PastaneBilgileriModel();
    PastaSepetiDAL pastaSepetiDAL = new PastaSepetiDAL();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pastaneler, container, false);
        ArrayList pastanelerArray= new ArrayList();
        final HashMap<String,UUID>pastaneIcerikMap=new HashMap<>();
        pastanelerListview = view.findViewById(R.id.pastanelerListview);

        try {
            for (int i = 0; i < pastaSepetiDAL.PastaneBilgilerList.size(); i++) {

                ObjectMapper mapper = new ObjectMapper();
                pastaneBilgileriModel = mapper.readValue(PastaSepetiDAL.PastaneBilgilerList.get(i), PastaneBilgileriModel.class);
                pastanelerArray.add(pastaneBilgileriModel.getPastaneAdi());
                pastaneIcerikMap.put(pastaneBilgileriModel.getPastaneAdi(), pastaneBilgileriModel.getPastaneId());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        pastanelerAdapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, pastanelerArray);
        pastanelerListview.setAdapter(pastanelerAdapter);

        pastanelerListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i =new Intent(view.getContext(), PastaneIcerik.class);
               String pastaneAdi= parent.getItemAtPosition(position).toString();
                i.putExtra("id",pastaneIcerikMap.get(pastaneAdi).toString());
                i.putExtra("position",""+position);
                startActivity(i);
            }
        });
        return view;
    }


}
