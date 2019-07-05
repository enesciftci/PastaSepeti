package com.example.ibrahimenescifti.pastasepeti.PastaneIcerik;

import java.util.UUID;

public class PastaneIcerikModel {
    UUID MenuId;
    UUID PastaneId;
    String UrunAdi;
    double UrunFiyati;
    String UrunDetay;
    UUID UrunAltKategoriId;
    public UUID getMenuId() {
        return MenuId;
    }

    public void setMenuId(UUID menuId) {
        MenuId = menuId;
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