package com.example.ibrahimenescifti.pastasepeti.Modeller;

import java.util.UUID;

public class KullaniciAdreslerModel {
    public UUID AdresId ;
    public UUID KullaniciId ;
    public String KullaniciSehir;
    public String KullaniciIlce;
    public String KullaniciSemt;
    public String AdresTipi;
    public String AdresBasligi;
    public String KullaniciAdres ;
    public String getKullaniciAdres() {
        return KullaniciAdres;
    }

    public void setKullaniciAdres(String kullaniciAdres) {
        KullaniciAdres = kullaniciAdres;
    }

    public String getKullaniciSehir() {
        return KullaniciSehir;
    }

    public void setKullaniciSehir(String kullaniciSehir) {
        KullaniciSehir = kullaniciSehir;
    }

    public String getKullaniciIlce() {
        return KullaniciIlce;
    }

    public void setKullaniciIlce(String kullaniciIlce) {
        KullaniciIlce = kullaniciIlce;
    }

    public String getKullaniciSemt() {
        return KullaniciSemt;
    }

    public void setKullaniciSemt(String kullaniciSemt) {
        KullaniciSemt = kullaniciSemt;
    }

    public String getAdresTipi() {
        return AdresTipi;
    }

    public void setAdresTipi(String adresTipi) {
        AdresTipi = adresTipi;
    }

    public String getAdresBasligi() {
        return AdresBasligi;
    }

    public void setAdresBasligi(String adresBasligi) {
        AdresBasligi = adresBasligi;
    }

    public UUID getAdresId() {
        return AdresId;
    }

    public void setAdresId(UUID adresId) {
        AdresId = adresId;
    }

    public UUID getKullaniciId() {
        return KullaniciId;
    }

    public void setKullaniciId(UUID kullaniciId) {
        KullaniciId = kullaniciId;
    }


}
