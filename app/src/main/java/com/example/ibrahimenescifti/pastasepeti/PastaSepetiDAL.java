package com.example.ibrahimenescifti.pastasepeti;

import android.app.Activity;
import android.os.AsyncTask;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PastaSepetiDAL extends Activity {

    String _url = "http://pastaSepetiWebServis.somee.com/";
  public static   ArrayList<String>UyeBilgilerList=new ArrayList<>();
   public static ArrayList<String>PastaneBilgilerList=new ArrayList<>();
   public static ArrayList<String >PastaneIcerikList=new ArrayList<>();
    public boolean girisDurumu;
   public static KullaniciBilgileri kullaniciBilgileri=new KullaniciBilgileri();

    public void GetUyeServisCalistir(String mail, String pass) {

        new GetUyeServis().execute(_url, mail, pass);
    }

    class GetUyeServis extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            String dosya = "";
            HttpURLConnection connection = null;
            BufferedReader br = null;
            try {
                String satir = "";

                URL url = new URL(strings[0] + "/pastasepeti.asmx/GetUye?email=" + strings[1] + "&sifre=" + strings[2]);
                String Url = url.toString();
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream is = connection.getInputStream();

                br = new BufferedReader(new InputStreamReader(is));

                while ((satir = br.readLine()) != null) {
                    dosya += satir;
                }
                dosya=xmlTemizle(dosya);
               /* JSONArray jsonArray=new JSONArray(dosya);
                for (int i=0;i<jsonArray.length();i++) {
                    ObjectMapper mapper = new ObjectMapper();
                    kullaniciBilgileri = mapper.readValue(PastaSepetiDAL.UyeBilgilerList.get(0), KullaniciBilgileri.class);
                }*/

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
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private String xmlTemizle(String xml) {
        xml = xml.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
        xml = xml.replace("<string xmlns=\"http://tempuri.org/\">", "");
        xml = xml.replace("</string>", "");
        try {
            JSONArray jsonArray = new JSONArray(xml);
            for (int i = 0; i < jsonArray.length(); i++) {

                UyeBilgilerList.add(jsonArray.getString(i));
            } ObjectMapper mapper = new ObjectMapper();
            kullaniciBilgileri = mapper.readValue(PastaSepetiDAL.UyeBilgilerList.get(0), KullaniciBilgileri.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }
    public void GetUyeKontrolCalistir(String mail, String pass) {
        new GetUyeKontrol().execute(_url, mail, pass);

    }

    class GetUyeKontrol extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String dosya = "";
            HttpURLConnection connection = null;
            BufferedReader br = null;
            try {
                String satir = "";
                URL url = new URL(strings[0] + "pastasepeti.asmx/giris?Mail=" + strings[1] + "&Sifre=" + strings[2]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream is = connection.getInputStream();

                br = new BufferedReader(new InputStreamReader(is));

                while ((satir = br.readLine()) != null) {
                    dosya += satir;
                }
                xmlTemizleGetUyeKontrol(dosya);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return dosya;
        }

        private boolean xmlTemizleGetUyeKontrol(String xml) {
            xml = xml.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
            xml = xml.replace("<boolean xmlns=\"http://tempuri.org/\">", "");
            xml = xml.replace("</boolean>", "");

            try {
                String durum = xml;
                for (int i = 0; i < durum.length(); i++) {

                    girisDurumu = Boolean.parseBoolean(durum);
                }
                try {
                } catch (Exception e) {
                    e.printStackTrace();
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
            HttpURLConnection connection = null;

            try {
                URL url = new URL(_url +("pastasepeti.asmx/uyeEkle?kullaniciAdi="+strings[0]+"&kullaniciSoyadi="+strings[1]+"&kullaniciMail="+strings[2]+"&kullaniciTelefonNumarasi="+strings[3]+"&kullaniciSehir="+strings[4]+"&kullaniciIlce="+strings[5]+"&kullaniciSemt="+strings[6]+"&kullaniciSifre="+strings[7]+""));
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                System.out.println(url);
                System.out.println(connection.getResponseMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void UyeSifremiUnuttumCalistir(String mail, String pass) {
        new UyeSifremiUnuttum().execute(mail, pass);
    }

    class UyeSifremiUnuttum extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
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

    class PastanelerGetir extends AsyncTask<String,String,String> {
        HttpURLConnection connection = null;

        @Override
        protected String doInBackground(String... strings) {
            try {
                PastaneBilgilerList.removeAll(PastaneBilgilerList);
                String dosya = "";
                BufferedReader br = null;
               URL url = new URL(_url + "pastasepeti.asmx/GetPastane?il="+strings[0]+"&ilce="+strings[1]+"&semt="+strings[2]+"");
               URL url1=new URL(url.toString());
                System.out.println(url1);
                connection = (HttpURLConnection) url1.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                String satir = "";
                br = new BufferedReader(new InputStreamReader(is));

                while ((satir = br.readLine()) != null) {
                    dosya += satir;
                }

              dosya=xmlTemizle(dosya);

                JSONArray jsonArray=new JSONArray(dosya);

                for (int i = 0; i < jsonArray.length(); i++) {
                   PastaneBilgilerList.add(jsonArray.getString(i));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
public String  xmlTemizle(String xml)
{
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
    class PastaneIcerikGetir extends AsyncTask<String ,String ,String> {
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
            HttpURLConnection connection = null;
            try {

                PastaneIcerikList.removeAll(PastaneIcerikList);
                String dosya = "";
                BufferedReader br = null;
                URL url = new URL(_url + "pastasepeti.asmx/GetPastaneIcerik?pastaneId=" + strings[0] + "");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                String satir = "";
                br = new BufferedReader(new InputStreamReader(is));

                while ((satir = br.readLine()) != null) {
                    dosya += satir;
                }

                dosya = xmlTemizle(dosya);
                System.out.println(dosya+" +++++++++++");
                JSONArray jsonArray = new JSONArray(dosya);
                for (int i = 0; i < jsonArray.length(); i++) {
                    PastaneIcerikList.add(jsonArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
}}