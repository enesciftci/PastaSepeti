package com.example.ibrahimenescifti.pastasepeti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class Adresler extends AppCompatActivity {

     Spinner spn_sehir, spn_ilce, spn_semt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adresler);
    }
}
