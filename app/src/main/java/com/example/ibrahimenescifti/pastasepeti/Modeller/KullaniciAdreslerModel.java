package com.example.ibrahimenescifti.pastasepeti.Modeller;

import java.util.List;
import java.util.UUID;

public class KullaniciAdreslerModel {
    public UUID AdresId ;
    public UUID KullaniciId ;
    public List<String> KullaniciAdres ;

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

    public List<String> getKullaniciAdres() {
        return KullaniciAdres;
    }

    public void setKullaniciAdres(List<String> kullaniciAdres) {
        KullaniciAdres = kullaniciAdres;
    }
}
