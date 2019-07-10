package com.example.ibrahimenescifti.pastasepeti.Anasayfa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ibrahimenescifti.pastasepeti.DALs.PastaSepetiDAL;
import com.example.ibrahimenescifti.pastasepeti.Inside.Inside;
import com.example.ibrahimenescifti.pastasepeti.Modeller.KullaniciBilgileriModel;
import com.example.ibrahimenescifti.pastasepeti.R;

public class Activity_Login extends AppCompatActivity {
    public final static String MAIL = "com.example.ibrahimenescifti.PastaSepeti.MAIL";
    public final static String PASS = "com.example.ibrahimenescifti.PastaSepeti.PASS";
    public final static String URL = "com.example.ibrahimenescifti.PastaSepeti.URL";
    RelativeLayout rellay1, rellay2;
    EditText edt_mail, edt_pass;
    Button login, forgot, register;
    PastaSepetiDAL pastaSepetiDAL=new PastaSepetiDAL();
  public static   KullaniciBilgileriModel kullaniciBilgileri=new KullaniciBilgileriModel();

    String Url,mail,pass;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);
        handler.postDelayed(runnable, 2000);
        CatchElements();


       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               mail=edt_mail.getText().toString();
               pass=edt_pass.getText().toString();
             kullaniciBilgileri.setMail(mail);
             kullaniciBilgileri.setSifre(pass);
               try {
                   pastaSepetiDAL.GetUyeKontrolCalistir(kullaniciBilgileri.getMail(),kullaniciBilgileri.getSifre());
                   Thread.sleep(2000);

                 if(pastaSepetiDAL.girisDurumu==true)
                 {
                     Intent i=new Intent(Activity_Login.this, Inside.class);
                     i.putExtra(URL,Url);
                     i.putExtra(MAIL,kullaniciBilgileri.getMail());
                     i.putExtra(PASS,kullaniciBilgileri.getSifre());
                     pastaSepetiDAL.GetUyeServisCalistir(mail,pass);
                     startActivity(i);
                 }
                 else if(pastaSepetiDAL.girisDurumu==false)
                 {
                     Toast.makeText(getApplicationContext(),"Kullanıcı Adı veya Şifre Yanlış",Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(),"Bağlantı Zaman Aşımına Uğradı",Toast.LENGTH_SHORT).show();
                 }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(Activity_Login.this, Register.class);
                    i.putExtra("Url", Url);
                    startActivity(i);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
       forgot.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Activity_Login.this, Forgot.class);
               i.putExtra("Url",Url);
               startActivity(i);
           }
       });
    }
    private void CatchElements() {
        edt_mail = findViewById(R.id.edt_userName);
        edt_pass = findViewById(R.id.edt_password);
        login = findViewById(R.id.btn_login);
        forgot = findViewById(R.id.btn_forgotIn);
        register = findViewById(R.id.btn_registerIn);
        Url = "http://pastaSepetiWebServis.somee.com/";
        //cardView=findViewById(R.id.cardView1);
    }

}
