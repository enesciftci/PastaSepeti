package com.example.ibrahimenescifti.pastasepeti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Sepet extends AppCompatActivity {
    TextView txtToplamFiyat,txtPastaneAdi;
    public static ArrayList<SepetModel> urunler=new ArrayList<>();
    ListView sepetListView;
    ArrayAdapter<String>sepetAdapter;
    Double toplamFiyat=0.0;
   ArrayList<String>sepet=new ArrayList<>();
   String pastaneAdi="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepet);
        txtToplamFiyat=findViewById(R.id.txtToplamFiyat);
        txtPastaneAdi=findViewById(R.id.txtPastaneAdi);
        sepetListView=findViewById(R.id.sepetListView);
        for (int i=0;i<urunler.size();i++)
        {
            sepet.add((urunler.get(i).urunAdi+urunler.get(i).urunFiyat));
            toplamFiyat+=urunler.get(i).urunFiyat;
            pastaneAdi=urunler.get(i).pastaneAdi;
        }
        sepetAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,sepet);
        sepetListView.setAdapter(sepetAdapter);
        txtToplamFiyat.setText(toplamFiyat.toString());
        txtPastaneAdi.setText(pastaneAdi);

    }
}
