package com.example.ibrahimenescifti.pastasepeti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ibrahimenescifti.pastasepeti.Modeller.SiparisBilgileriModel;

import java.util.ArrayList;
import java.util.UUID;

public class Sepet extends AppCompatActivity {
    TextView txtToplamFiyat, txtPastaneAdi;
    public static ArrayList<SiparisBilgileriModel> urunler = new ArrayList<>();
    ListView sepetListView;
    ArrayAdapter<String> sepetAdapter;
    Double toplamFiyat = 0.0;
    ArrayList<String> sepet = new ArrayList<>();
    String pastaneAdi = "";
    Button btnOdeme;
    UUID pastaneId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepet);
        txtToplamFiyat = findViewById(R.id.txtToplamFiyat);
        txtPastaneAdi = findViewById(R.id.txtPastaneAdi);
        sepetListView = findViewById(R.id.sepetListView);
        btnOdeme = findViewById(R.id.btnOdeme);
        for (int i = 0; i < urunler.size(); i++) {
            sepet.add((urunler.get(i).getUrunAdi() + "    Adet:    " + urunler.get(i).getUrunAdet() + "    Fiyat:    " + urunler.get(i).getUrunFiyat()));
            toplamFiyat += urunler.get(i).getUrunFiyat();
            pastaneAdi = urunler.get(i).getPastaneAdi();

        }
            sepetAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sepet);
            sepetListView.setAdapter(sepetAdapter);
        txtToplamFiyat.setText(toplamFiyat.toString());
        txtPastaneAdi.setText(pastaneAdi);
        btnOdeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sepet.this, Odeme.class);
                i.putExtra("SEPET",sepet);
                i.putExtra("TOPLAM",toplamFiyat);
                i.putExtra("PASTANEADI",pastaneAdi);
                i.putExtra("PASTANEID",pastaneId);
                startActivity(i);
            }
        });
        txtPastaneAdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

