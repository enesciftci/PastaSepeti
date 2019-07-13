package com.example.ibrahimenescifti.pastasepeti.DALs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PastaSepetiSQLiteDal {
    DatabaseHelper helper;

    public void sorguCalistir(String sorgu, Context context) {
        try {
            helper = new DatabaseHelper(context);
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SQLiteDatabase database = helper.getWritableDatabase();
        database.execSQL(sorgu);
    }

    public List<String> sehirGetir(Context context) {
        List<String> sehirler = new ArrayList<>();
        try {
            helper = new DatabaseHelper(context);
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SQLiteDatabase SQLiteDatabaseInstance_ = helper.getWritableDatabase();
        Cursor cursor = null;
        try {
            String query = "Select * from Sehirler";
            cursor = SQLiteDatabaseInstance_.rawQuery(query, null);

            while (cursor.moveToNext()) {
                String empName = cursor.getString(cursor.getColumnIndex("SehirAdi"));
                sehirler.add(empName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sehirler;
    }


    public HashMap<Integer, String> IlceGetir(int id) {
        SQLiteDatabase SQLiteDatabaseInstance_ = helper.getWritableDatabase();
        HashMap<Integer, String> ilceler = new HashMap<>();//String türünde bir liste oluşturduk.
        try {
            String query = "Select _id,ilce from Ilceler where il_id=" + id + "";
            Cursor cr = SQLiteDatabaseInstance_.rawQuery(query, null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.
            while (cr.moveToNext()) {//sırasıyla verileri listelememizi sağlıyor.
                ilceler.put(Integer.parseInt(cr.getString(cr.getColumnIndex("_id"))), cr.getString(cr.getColumnIndex("ilce")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ilceler;
    }

    public List<String> SemtGetir(int id, Context context) {

        try {

            helper = new DatabaseHelper(context);
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SQLiteDatabase SQLiteDatabaseInstance_ = helper.getWritableDatabase();
        List<String> semtler = new ArrayList<>();//String türünde bir liste oluşturduk.
        try {
            String query = "Select SemtAdi from SemtBucak where IlceId=" + id + "";
            Cursor cr = SQLiteDatabaseInstance_.rawQuery(query, null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.
            while (cr.moveToNext()) {//sırasıyla verileri listelememizi sağlıyor.
                semtler.add(cr.getString(cr.getColumnIndex("SemtAdi")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return semtler;
    }

}
