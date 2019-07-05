package com.example.ibrahimenescifti.pastasepeti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Forgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        final EditText edt_mail,edt_pass;
        final PastaSepetiDAL pastaSepetiDAL=new PastaSepetiDAL();
        Button btn_forgot;
        edt_pass=findViewById(R.id.edt_passwordForgot);
        btn_forgot=findViewById(R.id.btn_changeForgot);
        edt_mail=findViewById(R.id.edt_mailForgot);
        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password=edt_pass.getText().toString();
                String mail=edt_mail.getText().toString();
                pastaSepetiDAL.UyeSifremiUnuttumCalistir(mail,password);
            }
        });
    }
}
