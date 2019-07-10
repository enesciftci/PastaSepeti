package com.example.ibrahimenescifti.pastasepeti.Inside;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ibrahimenescifti.pastasepeti.Anasayfa.Activity_Login;
import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiDAL;
import com.example.ibrahimenescifti.pastasepeti.R;
import com.example.ibrahimenescifti.pastasepeti.Sepet;

import static com.example.ibrahimenescifti.pastasepeti.R.id.frame;

public class Inside extends AppCompatActivity {
    private TextView mTextMessage;
    private Button btnSepet;
    //    BottomNavigationView view=findViewById(R.id.nav_view);
    PastaSepetiDAL pastaSepetiDAL = new PastaSepetiDAL();
    PastanelerFragment pastanelerFragment = new PastanelerFragment();
    AyarlarFragment ayarlarFragment = new AyarlarFragment();
    SiparislerFragment siparislerFragment = new SiparislerFragment();
    AnasayfaFragment anasayfaFragment = new AnasayfaFragment();
    public static String il, ilce, semt;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_anasayfa:
                    setFragment(anasayfaFragment);
                    mTextMessage.setText(R.string.title_anasayfa);
                    btnSepetDurum(anasayfaFragment);
                    return true;
                case R.id.navigation_pastaneler:
                    setFragment(pastanelerFragment);
                    mTextMessage.setText(R.string.title_pastaneler);
                    btnSepetDurum(pastanelerFragment);
                    return true;
                case R.id.navigation_siparisler:
                    mTextMessage.setText(R.string.title_siparisler);
                    setFragment(siparislerFragment);
                    btnSepetDurum(siparislerFragment);
                    return true;
                case R.id.navigation_ayarlar:
                    setFragment(ayarlarFragment);
                    btnSepetDurum(ayarlarFragment);
                    mTextMessage.setText(R.string.title_ayarlar);
                    return true;
            }
            return false;
        }
    };

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);
        Intent i = getIntent();
        String mail = i.getStringExtra(Activity_Login.MAIL);
        String pass = i.getStringExtra(Activity_Login.PASS);
        btnSepet = findViewById(R.id.btnSepet);
        try {
            Thread.sleep(1500);
            il = PastaSepetiDAL.kullaniciBilgileri.getSehir();
            ilce = PastaSepetiDAL.kullaniciBilgileri.getIlce();
            semt = PastaSepetiDAL.kullaniciBilgileri.getSemt();
            pastaSepetiDAL.GetPastaneCalistir(il, ilce, semt);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BottomNavigationView navView = findViewById(R.id.nav_view);
        setFragment(anasayfaFragment);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        btnSepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Inside.this, Sepet.class);
                startActivity(i);
            }
        });
    }

    void btnSepetDurum(Fragment fragment) {
        if (fragment == ayarlarFragment)
            btnSepet.setVisibility(View.INVISIBLE);
        else
            btnSepet.setVisibility(View.VISIBLE);
    }

}
