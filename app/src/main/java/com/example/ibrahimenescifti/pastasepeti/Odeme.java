package com.example.ibrahimenescifti.pastasepeti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiDAL;
import com.example.ibrahimenescifti.pastasepeti.Modeller.KullaniciAdreslerModel;
import com.example.ibrahimenescifti.pastasepeti.Modeller.SiparisBilgileriModel;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Odeme extends AppCompatActivity {
    PastaSepetiDAL pastaSepetiDAL = new PastaSepetiDAL();
    ListView urunlerListView;
    ArrayList<String> sepet = new ArrayList<>();
    ArrayList<SiparisBilgileriModel> sepetOdeme = new ArrayList<>();
    double toplamFiyat;
    String pastaneAdi;
    String seciliAdres,odemeTuru,siparisNotu;
    CardView cardAdresler;
    Button btn_odeme;
    ArrayAdapter<String> urunlerAdapter;
    Spinner spn_adresler;
    ArrayAdapter adresAdapter;
    RadioGroup rdg_odemeTuru;
    TextView txt_toplamTutar;
    EditText edt_siparisNotu;
    KullaniciAdreslerModel kullaniciAdreslerModel = new KullaniciAdreslerModel();
    ArrayList<String> adreslerList;
    Map<String, UUID> adreslerMap ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odeme);
        CatchElements();
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
        AdresGetir();
        txt_toplamTutar.setText(String.valueOf(toplamFiyat));
        urunlerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sepet);
        urunlerListView.setAdapter(urunlerAdapter);
        cardAdresler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Odeme.this, Adresler.class);
                i.putExtra("KULLANICIID", PastaSepetiDAL.kullaniciBilgileri.getKullaniciId().toString());
                startActivity(i);
            }
        });
        btn_odeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int secilenOdemeTuru=  rdg_odemeTuru.getCheckedRadioButtonId();
                if(!edt_siparisNotu.getText().toString().isEmpty())
                {
                    siparisNotu=edt_siparisNotu.getText().toString();
                }
                else
                {
                    siparisNotu="Not Yok";
                }
                switch (secilenOdemeTuru)
                {
                    case R.id.radioNakit:odemeTuru="Nakit";
                    case R.id.radioKredi:odemeTuru="Banka/Kredi Kartı";
                }
                for (int i = 0; i < Sepet.urunler.size(); i++) {//5
                    Sepet.urunler.get(i).setKullaniciAdres(seciliAdres);
                    Sepet.urunler.get(i).setSiparisNotu(siparisNotu);
                    Sepet.urunler.get(i).setOdemeTuru(odemeTuru);
                    sepetOdeme.add(Sepet.urunler.get(i));
                    Toast.makeText(Odeme.this, "Sipariş Alındı", Toast.LENGTH_SHORT).show();
                }
                pastaSepetiDAL.SiparisGecCalistir(sepetOdeme);// Burada sepetodemeyi gönder olmazsa diğer tarafı arrayliste çevir gönder
               // finish();
            }
        });
        spn_adresler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AdresGetir();
                seciliAdres = (spn_adresler.getItemAtPosition(position)).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void AdresGetir() {
        try {
            adreslerList= new ArrayList();
            adreslerMap= new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();
            for (int i = 0; i < PastaSepetiDAL.AdresList.size(); i++) {
                kullaniciAdreslerModel = mapper.readValue(PastaSepetiDAL.AdresList.get(i), KullaniciAdreslerModel.class);
                String adres = kullaniciAdreslerModel.getKullaniciAdres().toString().replace("[", "");
                adres = adres.replace("]", "");
              adreslerList.add(adres);
                adreslerMap.put(kullaniciAdreslerModel.getKullaniciAdres().toString(), kullaniciAdreslerModel.getAdresId());
            }
            adresAdapter = new ArrayAdapter<>(Odeme.this, android.R.layout.simple_spinner_item, adreslerList);
            spn_adresler.setAdapter(adresAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void CatchElements() {
        edt_siparisNotu=findViewById(R.id.edt_siparisNotu);
        txt_toplamTutar = findViewById(R.id.txtToplamTutar);
        rdg_odemeTuru = findViewById(R.id.radioGroup);
        spn_adresler = findViewById(R.id.spn_adresler);
        urunlerListView = findViewById(R.id.tumUrunlerListView);
        cardAdresler = findViewById(R.id.cardAdresler);
        btn_odeme = findViewById(R.id.btn_odeme);
    }

}
