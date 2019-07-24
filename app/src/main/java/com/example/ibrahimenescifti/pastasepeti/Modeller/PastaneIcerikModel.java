package com.example.ibrahimenescifti.pastasepeti.Modeller;

import java.util.UUID;

public class PastaneIcerikModel {
    UUID UrunId;
    UUID PastaneId;
    String UrunAdi;
    double UrunFiyati;
    String UrunDetay;
    UUID UrunAltKategoriId;

    public UUID getUrunId() {
        return UrunId;
    }

    public void setUrunId(UUID urunId) {
        UrunId = urunId;
    }

    public UUID getPastaneId() {
        return PastaneId;
    }

    public void setPastaneId(UUID pastaneId) {
        PastaneId = pastaneId;
    }

    public String getUrunAdi() {
        return UrunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        UrunAdi = urunAdi;
    }

    public double getUrunFiyat() {
        return UrunFiyati;
    }

    public void setUrunFiyat(double urunFiyat) {
        UrunFiyati = urunFiyat;
    }

    public String getUrunDetay() {
        return UrunDetay;
    }

    public void setUrunDetay(String urunDetay) {
        UrunDetay = urunDetay;
    }

    public UUID getUrunAltKategori() {
        return UrunAltKategoriId;
    }

    public void setUrunAltKategori(UUID urunAltKategori) {
        UrunAltKategoriId = urunAltKategori;
    }


}