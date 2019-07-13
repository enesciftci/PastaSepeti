package com.example.ibrahimenescifti.pastasepeti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiDAL;
import com.example.ibrahimenescifti.pastasepeti.Modeller.KullaniciAdreslerModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Odeme extends AppCompatActivity {
    PastaSepetiDAL pastaSepetiDAL = new PastaSepetiDAL();
    KullaniciAdreslerModel kullaniciAdreslerModel = new KullaniciAdreslerModel();
    ArrayList<String> adreslerList = new ArrayList();
    Map<String, UUID> adreslerMap = new HashMap<>();
    ArrayAdapter<String> adreslerAdapter;
    ListView adreslerListView, urunlerListView;
    ArrayList<String> sepet = new ArrayList<>();
    double toplamFiyat;
    String pastaneAdi;
    CardView cardOdeme;
    ArrayAdapter<String> urunlerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odeme);
        // adreslerListView = findViewById(R.id.adreslerListView);
        urunlerListView = findViewById(R.id.tumUrunlerListView);
        cardOdeme = findViewById(R.id.cardAdresler);
        Intent sepetIntent = getIntent();
        toplamFiyat = sepetIntent.getDoubleExtra("TOPLAM", 0);
        sepet = sepetIntent.getStringArrayListExtra("SEPET");
        pastaneAdi = sepetIntent.getStringExtra("PASTANEADI");
        try {
            pastaSepetiDAL.AdresGetirCalistir(PastaSepetiDAL.kullaniciBilgileri.getKullaniciId().toString());
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
      /*  try {
            for (int i = 0; i < PastaSepetiDAL.AdresList.size(); i++) {

                ObjectMapper mapper = new ObjectMapper();
                kullaniciAdreslerModel = mapper.readValue(PastaSepetiDAL.AdresList.get(i), KullaniciAdreslerModel.class);
                String adres = kullaniciAdreslerModel.getKullaniciAdres().toString().replace("[", "");
                adres = adres.replace("]", "");
                adreslerList.add(adres);
                adreslerMap.put(kullaniciAdreslerModel.getKullaniciAdres().toString(), kullaniciAdreslerModel.getAdresId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        adreslerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, adreslerList);
        adreslerListView.setAdapter(adreslerAdapter);
        adreslerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seciliAdres = (adreslerListView.getItemAtPosition(position)).toString();
                Toast.makeText(Odeme.this, seciliAdres, Toast.LENGTH_LONG).show();
            }
        });*/
        for (int i = 0; i < sepet.size(); i++) {
            System.out.println("++++++++++++++++++++++" + sepet.get(i));
        }
        urunlerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sepet);
        urunlerListView.setAdapter(urunlerAdapter);
        cardOdeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Odeme.this,Adresler.class);
                startActivity(i);
            }
        });
    }

}
