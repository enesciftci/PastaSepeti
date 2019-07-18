package com.example.ibrahimenescifti.pastasepeti.DALs;

import android.os.AsyncTask;

import com.example.ibrahimenescifti.pastasepeti.Modeller.KullaniciAdreslerModel;
import com.example.ibrahimenescifti.pastasepeti.Modeller.KullaniciBilgileriModel;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;

public class PastaSepetiDAL {

  private static String _url = "http://pastaSepetiWebServis.somee.com/";
  public static   ArrayList<String>UyeBilgilerList=new ArrayList<>();
   public static ArrayList<String>PastaneBilgilerList=new ArrayList<>();
   public static ArrayList<String >PastaneIcerikList=new ArrayList<>();
   public static ArrayList<String> AdresList=new ArrayList<>();
    public boolean girisDurumu;
    public static KullaniciAdreslerModel kullaniciAdreslerModel=new KullaniciAdreslerModel();
   public static KullaniciBilgileriModel kullaniciBilgileri=new KullaniciBilgileriModel();
   public HttpURLConnection conn;
    JSONObject postDataParams;
   public void postBaglanti(URL url) {
       try {
          conn = (HttpURLConnection) url.openConnection();
           conn.setReadTimeout(3000 /* milliseconds */);
           conn.setConnectTimeout(3000 /* milliseconds */);
           conn.setRequestMethod("POST"); // Web Sayfasına post tipinde istekte bulun
           conn.setDoInput(true);
           conn.setDoOutput(true);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   public String postVeriGonder()
   {
       try{
           OutputStream os = conn.getOutputStream();
           BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
           writer.write(getPostDataString(postDataParams));

           writer.flush();
           writer.close();
           os.close();

           int responseCode=conn.getResponseCode();

           if (responseCode == HttpsURLConnection.HTTP_OK) {

               BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
               StringBuffer sb = new StringBuffer("");
               String line;

               while((line = in.readLine()) != null) {

                   sb.append(line);
                   break;
               }

               in.close();
               return sb.toString();

           }
           else {
               return "false : "+responseCode;
           }
       }
       catch(Exception e){
           return "Exception: " + e.getMessage();
       }
   }
    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next().toString();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
    public void GetUyeServisCalistir(String mail, String pass) {

        new GetUyeServis().execute(mail, pass);
    }

   static class GetUyeServis extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            String dosya = "";
            HttpURLConnection connection ;
            BufferedReader br;
            try {
                String satir ;
                URL url = new URL(_url + "pastasepeti.asmx/GetUye?email=" + strings[0] + "&sifre=" + strings[1]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();

                br = new BufferedReader(new InputStreamReader(is));

                while ((satir = br.readLine()) != null) {
                    dosya += satir;
                }
                dosya=xmlTemizle(dosya);
                JSONArray jsonArray=new JSONArray(dosya);
                for (int i=0;i<jsonArray.length();i++) {
                    ObjectMapper mapper = new ObjectMapper();
                    kullaniciBilgileri = mapper.readValue(UyeBilgilerList.get(0), KullaniciBilgileriModel.class);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
   static String xmlTemizle(String xml) {
        xml = xml.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
        xml = xml.replace("<string xmlns=\"http://tempuri.org/\">", "");
        xml = xml.replace("</string>", "");
        try {
            JSONArray jsonArray = new JSONArray(xml);
            for (int i = 0; i < jsonArray.length(); i++) {

                UyeBilgilerList.add(jsonArray.getString(i));
            } ObjectMapper mapper = new ObjectMapper();
            kullaniciBilgileri = mapper.readValue(UyeBilgilerList.get(0), KullaniciBilgileriModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }
    public void GetUyeKontrolCalistir(String mail, String pass) {
        new GetUyeKontrol().execute(mail, pass);

    }

    class GetUyeKontrol extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder dosya = new StringBuilder();
            HttpURLConnection connection ;
            BufferedReader br ;
            try {
                String satir ;
                URL url = new URL(_url+ "pastasepeti.asmx/UyeGiris?Mail=" + strings[0] + "&Sifre=" + strings[1]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream is = connection.getInputStream();

                br = new BufferedReader(new InputStreamReader(is));

                while ((satir = br.readLine()) != null) {
                    dosya.append(satir);
                }
                xmlTemizleGetUyeKontrol(dosya.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }

            return dosya.toString();
        }

        private boolean xmlTemizleGetUyeKontrol(String xml) {
            xml = xml.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
            xml = xml.replace("<boolean xmlns=\"http://tempuri.org/\">", "");
            xml = xml.replace("</boolean>", "");

            try {

                for (int i = 0; i < xml.length(); i++) {

                    girisDurumu = Boolean.parseBoolean(xml);
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            return girisDurumu;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    public void UyeKayitCalistir(String[] bilgiler) {

        new UyeKayit().execute(bilgiler);
    }

    class UyeKayit extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                URL url = new URL(_url + "pastasepeti.asmx/UyeEkle"); //İstekte bulunulacak sayfa

                 postDataParams = new JSONObject();
                postDataParams.put("kullaniciAdi", strings[0]);
                postDataParams.put("kullaniciSoyadi", strings[1]);
                postDataParams.put("kullaniciMail", strings[2]);
                postDataParams.put("kullaniciTelefonNumarasi", strings[3]);
                postDataParams.put("kullaniciSehir", strings[4]);
                postDataParams.put("kullaniciIlce", strings[5]);
                postDataParams.put("kullaniciSemt", strings[6]);
                postDataParams.put("kullaniciSifre", strings[7]);
                postBaglanti(url);
            }catch (Exception e) {
                e.printStackTrace();
            }
          return postVeriGonder();
        }
    }

    public void UyeSifremiUnuttumCalistir(String mail, String pass) {
        new UyeSifremiUnuttum().execute(mail, pass);
    }

    static class UyeSifremiUnuttum extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection ;
            try {
                URL url = new URL(_url + "pastasepeti.asmx/SifremiUnuttum?Mail=" + strings[0] + "&Sifre=" + strings[1] + "");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
             } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    public void GetPastaneCalistir(String pastaneIl, String pastaneIlce, String pastaneSemt) {
        new PastanelerGetir().execute( pastaneIl, pastaneIlce, pastaneSemt);
    }

   static class PastanelerGetir extends AsyncTask<String,String,String> {
        HttpURLConnection connection = null;

        @Override
        protected String doInBackground(String... strings) {
            try {
                PastaneBilgilerList.removeAll(PastaneBilgilerList);
                StringBuilder dosya=new StringBuilder();
                BufferedReader br ;
               URL url = new URL(_url + "pastasepeti.asmx/GetPastane?il="+strings[0]+"&ilce="+strings[1]+"&semt="+strings[2]+"");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                String satir ;
                br = new BufferedReader(new InputStreamReader(is));
                while ((satir = br.readLine()) != null) {
                    dosya.append(satir);
                }

                JSONArray jsonArray=new JSONArray( xmlTemizle(dosya.toString()));

                for (int i = 0; i < jsonArray.length(); i++) {
                   PastaneBilgilerList.add(jsonArray.getString(i));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        public String  xmlTemizle(String xml) {

            xml = xml.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
            xml = xml.replace("<string xmlns=\"http://tempuri.org/\">", "");
            xml = xml.replace("</string>", "");
            return xml;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String  s) {
            super.onPostExecute(s);
        }
    }
    public void PastaneIcerikGetirCalistir(String pastaneId)
    {
        new PastaneIcerikGetir().execute(pastaneId);
    }
    static class PastaneIcerikGetir extends AsyncTask<String ,String ,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection ;
            try {

                PastaneIcerikList.removeAll(PastaneIcerikList);
                StringBuilder dosya = new StringBuilder();
                BufferedReader br ;
                URL url = new URL(_url + "pastasepeti.asmx/GetPastaneIcerik?pastaneId=" + strings[0] + "");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                String satir ;
                br = new BufferedReader(new InputStreamReader(is));

                while ((satir = br.readLine()) != null) {
                    dosya.append(satir);
                }
                JSONArray jsonArray = new JSONArray(xmlTemizle(dosya.toString()));
                for (int i = 0; i < jsonArray.length(); i++) {
                    PastaneIcerikList.add(jsonArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
    //////////////////////////

    static String xmlTemizleGetAdres(String xml) {
        xml = xml.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
        xml = xml.replace("<string xmlns=\"http://tempuri.org/\">", "");
        xml = xml.replace("</string>", "");
        return xml;
    }
    public void AdresGetirCalistir(String kullaniciId)
    {
        new AdresGetir().execute(kullaniciId);
    }
    static class AdresGetir extends AsyncTask<String ,String ,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {//Url güncellenecek msdn forumundan gelen bilgiye göre
            HttpURLConnection connection ;
            try {

                AdresList.clear();
                StringBuilder dosya = new StringBuilder();
                BufferedReader br ;
                URL url = new URL(_url + ("pastasepeti.asmx/GetAdresler?kullaniciId="+strings[0]+""));
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                String satir ;
                br = new BufferedReader(new InputStreamReader(is));
                while ((satir = br.readLine()) != null) {
                    dosya.append(satir);
                }
                JSONArray jsonArray = new JSONArray(xmlTemizleGetAdres(dosya.toString()));
                for (int i = 0; i < jsonArray.length(); i++) {
                    AdresList.add(jsonArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
    private String AdresGuncelle(UUID adresId,String adres)
    {
        try {

            URL url = new URL(_url + "pastasepeti.asmx/AdresGuncelle"); //İstekte bulunulacak sayfa
            postDataParams = new JSONObject();
            postDataParams.put("adresId", adresId.toString());
            postDataParams.put("adres", adres);
            postBaglanti(url);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return postVeriGonder();
    }

    private String AdresEkle (UUID kullaniciId,String adres)
    {

        try {

            URL url = new URL(_url + "pastasepeti.asmx/AdresEkle"); //İstekte bulunulacak sayfa
            postDataParams = new JSONObject();
            postDataParams.put("kullaniciId", kullaniciId.toString());
            postDataParams.put("adres", adres);
            postBaglanti(url);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return postVeriGonder();

    }
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}