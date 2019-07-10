package com.example.ibrahimenescifti.pastasepeti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiDAL;

import java.util.HashMap;
import java.util.UUID;

public class UrunDetay extends AppCompatActivity {

    TextView txtUrunDetay,txtUrunAdet,txtUrunFiyat;
    Button btnArttir,btnAzalt,btnSepeteEkle;
    int adet=1;
    double fiyat;
   public static final UUID siparisNo=UUID.randomUUID();
    SepetModel sepetModel=new SepetModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_icerik);
        CatchElements();
        final HashMap<String,String>urun=new HashMap<>();
        Intent i=getIntent();
       final String urunAdi=i.getStringExtra("URUNADI");
       final Double urunFiyat=i.getDoubleExtra("URUNFIYAT",0);
       final String urunDetay=i.getStringExtra("URUNDETAY");
       final String pastaneAdi=i.getStringExtra("PASTANEADI");
       txtUrunDetay.setText(urunDetay);
       txtUrunFiyat.setText(urunFiyat.toString());
       btnArttir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               adet =Integer.parseInt(txtUrunAdet.getText().toString());
               if(adet<10) {
                   adet=adet+1;
                   fiyat=urunFiyat*adet;
                   txtUrunAdet.setText(String.valueOf(adet));
                   txtUrunFiyat.setText(String.valueOf(fiyat));
               }
           }
       });
       btnAzalt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               adet =Integer.parseInt(txtUrunAdet.getText().toString());
               if(adet>1) {
                   adet=adet-1;
                   fiyat=urunFiyat*adet;
                   txtUrunAdet.setText(String.valueOf(adet));
                   txtUrunFiyat.setText(String.valueOf(fiyat));
               }
           }
       });
       btnSepeteEkle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sepetModel.setUrunAdi(urunAdi);
               sepetModel.setUrunDetay(urunDetay);
               sepetModel.setPastaneAdi(pastaneAdi);
               sepetModel.setUrunFiyat(Double.parseDouble(txtUrunFiyat.getText().toString()));
               sepetModel.setKullaniciAdi(PastaSepetiDAL.kullaniciBilgileri.getAd());
               sepetModel.setKullaniciSoyad(PastaSepetiDAL.kullaniciBilgileri.getSoyad());
               sepetModel.setKullaniciTelefonNumarasi(PastaSepetiDAL.kullaniciBilgileri.getTelefon());
               sepetModel.setKullaniciSehir(PastaSepetiDAL.kullaniciBilgileri.getSehir());
               sepetModel.setKullaniciIlce(PastaSepetiDAL.kullaniciBilgileri.getIlce());
               sepetModel.setKullaniciSemt(PastaSepetiDAL.kullaniciBilgileri.getIlce());
               sepetModel.setKullaniciAdres(PastaSepetiDAL.kullaniciBilgileri.getAdres());
               Sepet.urunler.add(sepetModel);
           }
       });
    }
    void CatchElements()
    {
        btnSepeteEkle=findViewById(R.id.btnSepeteEkle);
        btnArttir=findViewById(R.id.btnArttır);
        btnAzalt=findViewById(R.id.btnAzalt);
        txtUrunDetay=findViewById(R.id.txtUrunDetay);
        txtUrunAdet=findViewById(R.id.txtUrunAdet);
        txtUrunFiyat=findViewById(R.id.txtUrunFiyat);
    }
}
