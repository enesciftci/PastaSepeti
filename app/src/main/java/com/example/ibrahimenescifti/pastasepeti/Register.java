package com.example.ibrahimenescifti.pastasepeti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Register extends AppCompatActivity {
    ArrayAdapter<String> illerAdapter;
    public ArrayAdapter<SehirlerIlcelerSemtlerModel> ilcelerAdapter;
    public ArrayAdapter<String> semtlerAdapter;
    PastaSepetiDAL pastaSepetiDAL = new PastaSepetiDAL();
    PastaSepetiSQLiteDal pastaSepetiSQLiteDal = new PastaSepetiSQLiteDal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText edt_ad, edt_soyad, edt_mail, edt_telefon, edt_sifre;
        final Spinner spn_sehir, spn_ilce, spn_semt;
        Button btn_kaydol;
        btn_kaydol = findViewById(R.id.btn_register);
        edt_ad = findViewById(R.id.edt_userName);
        edt_soyad = findViewById(R.id.edt_surname);
        edt_mail = findViewById(R.id.edt_mail);
        edt_telefon = findViewById(R.id.edt_phoneNumber);
        edt_sifre = findViewById(R.id.edt_password);
        spn_sehir = findViewById(R.id.spn_city);
        spn_ilce = findViewById(R.id.spn_district);
        spn_semt = findViewById(R.id.spn_neighborhood);
        List<String> sehirler = new ArrayList<>();
        sehirler.addAll(pastaSepetiSQLiteDal.sehirGetir(this));

        illerAdapter = new ArrayAdapter<>(Register.this, android.R.layout.simple_spinner_item, sehirler);
        spn_sehir.setAdapter(illerAdapter);


        spn_sehir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    int id_ = spn_sehir.getSelectedItemPosition() + 1;
                    List<SehirlerIlcelerSemtlerModel> ilceler = new ArrayList<SehirlerIlcelerSemtlerModel>();
                    for (Map.Entry<Integer, String> entry : pastaSepetiSQLiteDal.IlceGetir(id_).entrySet()) {
                       int key = entry.getKey();
                        String value = entry.getValue();
                        ilceler.add(new SehirlerIlcelerSemtlerModel(value, key));
                    }
                    ilcelerAdapter = new ArrayAdapter<>(Register.this, android.R.layout.simple_spinner_item, ilceler);
                    ilcelerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spn_ilce.setAdapter(ilcelerAdapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn_ilce.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SehirlerIlcelerSemtlerModel sehirlerIlcelerSemtlerModel =  (SehirlerIlcelerSemtlerModel) parent.getItemAtPosition(position);
                PastaSepetiSQLiteDal pastaSepetiSQLiteDal = new PastaSepetiSQLiteDal();
                List<String> semtler = new ArrayList<>();

                semtler.addAll(pastaSepetiSQLiteDal.SemtGetir(sehirlerIlcelerSemtlerModel.getIlceId(), Register.this));
                semtlerAdapter = new ArrayAdapter<>(Register.this, android.R.layout.simple_spinner_item, semtler);
                spn_semt.setAdapter(semtlerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn_semt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] bilgiler = new String[]{
                        edt_ad.getText().toString(),
                        edt_soyad.getText().toString(),
                        edt_mail.getText().toString(),
                        edt_telefon.getText().toString(),
                        spn_sehir.getSelectedItem().toString(),
                        spn_ilce.getSelectedItem().toString(),
                        spn_semt.getSelectedItem().toString(),
                        edt_sifre.getText().toString(),
                };
                pastaSepetiDAL.UyeKayitCalistir(bilgiler);
                try {

                    Toast.makeText(getApplicationContext(), "Kayıt Başarıyla Eklendi", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Bir hata var", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
