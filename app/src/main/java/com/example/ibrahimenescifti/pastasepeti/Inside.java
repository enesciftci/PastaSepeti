package com.example.ibrahimenescifti.pastasepeti;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import static com.example.ibrahimenescifti.pastasepeti.R.id.frame;

public class Inside extends AppCompatActivity {
    private TextView mTextMessage;

//    BottomNavigationView view=findViewById(R.id.nav_view);
    PastaSepetiDAL pastaSepetiDAL=new PastaSepetiDAL();
    PastanelerFragment pastanelerFragment=new PastanelerFragment();
    AyarlarFragment ayarlarFragment=new AyarlarFragment();
    SiparislerFragment siparislerFragment=new SiparislerFragment();
    AnasayfaFragment anasayfaFragment=new AnasayfaFragment();
    public static String il,ilce,semt;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_anasayfa:
                    setFragment(anasayfaFragment);
                    mTextMessage.setText(R.string.title_anasayfa);
                    return true;
                case R.id.navigation_pastaneler:
                    setFragment(pastanelerFragment);
                    mTextMessage.setText(R.string.title_pastaneler);
                    return true;
                case R.id.navigation_siparisler:
                    mTextMessage.setText(R.string.title_siparisler);
                    setFragment(siparislerFragment);
                    return true;
                case R.id.navigation_ayarlar:
                    setFragment(ayarlarFragment);
                    mTextMessage.setText(R.string.title_ayarlar);
                    return true;
            }
            return false;
        }
    };
private void setFragment(Fragment fragment)
{
    FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
    fragmentTransaction.replace(frame,fragment);
    fragmentTransaction.commit();
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);
        Intent i=getIntent();
        String mail=i.getStringExtra(Activity_Login.MAIL);
        String pass=i.getStringExtra(Activity_Login.PASS);

        try {
            Thread.sleep(1500);
            il=PastaSepetiDAL.kullaniciBilgileri.getSehir();
            ilce=PastaSepetiDAL.kullaniciBilgileri.getIlce();
            semt=PastaSepetiDAL.kullaniciBilgileri.getSemt();
            pastaSepetiDAL.GetPastaneCalistir(il, ilce, semt);
            Thread.sleep(1000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        BottomNavigationView navView = findViewById(R.id.nav_view);
        setFragment(anasayfaFragment);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
