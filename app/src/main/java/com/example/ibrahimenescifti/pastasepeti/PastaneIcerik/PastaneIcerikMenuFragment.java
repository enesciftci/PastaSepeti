package com.example.ibrahimenescifti.pastasepeti.PastaneIcerik;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiDAL;
import com.example.ibrahimenescifti.pastasepeti.Inside.PastanelerFragment;
import com.example.ibrahimenescifti.pastasepeti.Modeller.PastaneIcerikModel;
import com.example.ibrahimenescifti.pastasepeti.R;
import com.example.ibrahimenescifti.pastasepeti.UrunDetay;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;

public class PastaneIcerikMenuFragment extends Fragment {
    PastaneIcerikModel pastaneIcerikModel = new PastaneIcerikModel();
    public ListView pastaneIcerikMenuListView;
    TextView urunDetay, urunAdi;

    public PastaneIcerikMenuFragment() {
        // Required empty public constructor
    }

    ArrayAdapter<Object> icerikAdapter;
    HashMap<String, PastaneIcerikModel> icerikMap = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pastane_icerik_menu, container, false);
        // Inflate the layout for this fragment
        urunDetay = view.findViewById(R.id.textViewUrunDetay);
        urunAdi = view.findViewById(R.id.textViewUrunAdi);
        pastaneIcerikMenuListView = view.findViewById(R.id.pastaneIcerikMenuListView);
        try {

            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            for (int i = 0; i < PastaSepetiDAL.PastaneIcerikList.size(); i++) {
                pastaneIcerikModel = mapper.readValue(PastaSepetiDAL.PastaneIcerikList.get(i), PastaneIcerikModel.class);
                icerikMap.put(pastaneIcerikModel.getUrunAdi(), pastaneIcerikModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        icerikAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, icerikMap.keySet().toArray());
        pastaneIcerikMenuListView.setAdapter(icerikAdapter);

        pastaneIcerikMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seciliUrun = (pastaneIcerikMenuListView.getItemAtPosition(position)).toString();
                Intent i = new Intent(view.getContext(), UrunDetay.class);
                i.putExtra("URUNADI", icerikMap.get(seciliUrun).getUrunAdi());
                i.putExtra("URUNDETAY", icerikMap.get(seciliUrun).getUrunDetay());
                i.putExtra("URUNFIYAT", icerikMap.get(seciliUrun).getUrunFiyat());
                i.putExtra("PASTANEADI", PastanelerFragment.pastaneAdi);
                i.putExtra("PASTANEID", icerikMap.get(seciliUrun).getPastaneId().toString());
                startActivity(i);

            }
        });
        return view;
    }
}