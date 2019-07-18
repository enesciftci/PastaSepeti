package com.example.ibrahimenescifti.pastasepeti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiSQLiteDal;
import com.example.ibrahimenescifti.pastasepeti.Modeller.KullaniciAdreslerModel;
import com.example.ibrahimenescifti.pastasepeti.Modeller.SehirlerIlcelerSemtlerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Adresler extends AppCompatActivity {

    PastaSepetiSQLiteDal pastaSepetiSQLiteDal = new PastaSepetiSQLiteDal();
    public ArrayAdapter<String> illerAdapter;
    public ArrayAdapter<SehirlerIlcelerSemtlerModel> ilcelerAdapter;
    public ArrayAdapter<String> semtlerAdapter;
    Button btn_adresKaydet;
    KullaniciAdreslerModel kullaniciAdreslerModel = new KullaniciAdreslerModel();
    Spinner spn_sehir, spn_ilce, spn_semt;
    EditText edt_AdresDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adresler);
        catchElements();
        List<String> sehirler = new ArrayList<>();
        sehirler.addAll(pastaSepetiSQLiteDal.sehirGetir(this));

        illerAdapter = new ArrayAdapter<>(Adresler.this, android.R.layout.simple_spinner_item, sehirler);
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
                    ilcelerAdapter = new ArrayAdapter<>(Adresler.this, android.R.layout.simple_spinner_item, ilceler);
                    ilcelerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spn_ilce.setAdapter(ilcelerAdapter);
                    kullaniciAdreslerModel.setKullaniciSehir(spn_sehir.getItemAtPosition(position).toString());

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
                SehirlerIlcelerSemtlerModel sehirlerIlcelerSemtlerModel = (SehirlerIlcelerSemtlerModel) parent.getItemAtPosition(position);
                PastaSepetiSQLiteDal pastaSepetiSQLiteDal = new PastaSepetiSQLiteDal();
                List<String> semtler = new ArrayList<>();

                semtler.addAll(pastaSepetiSQLiteDal.SemtGetir(sehirlerIlcelerSemtlerModel.getIlceId(), Adresler.this));
                semtlerAdapter = new ArrayAdapter<>(Adresler.this, android.R.layout.simple_spinner_item, semtler);
                spn_semt.setAdapter(semtlerAdapter);
                kullaniciAdreslerModel.setKullaniciIlce(spn_ilce.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn_semt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                kullaniciAdreslerModel.setKullaniciSemt(spn_semt.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_adresKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kullaniciAdreslerModel.setKullaniciAdres(edt_AdresDetay.getText().toString());
            }
        });
    }

    void catchElements() {
        edt_AdresDetay=findViewById(R.id.edtAdres);
        btn_adresKaydet = findViewById(R.id.btn_adresKaydet);
        spn_sehir = findViewById(R.id.spn_sehir);
        spn_ilce = findViewById(R.id.spn_ilce);
        spn_semt = findViewById(R.id.spn_semtler);
    }
}
