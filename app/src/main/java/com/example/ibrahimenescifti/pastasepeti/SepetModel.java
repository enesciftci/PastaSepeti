package com.example.ibrahimenescifti.pastasepeti;

import java.util.UUID;

public class SepetModel {
    UUID siparisNo;
    String kullaniciAdi;
    String kullaniciSoyad;
    String kullaniciTelefonNumarasi;
    String kullaniciSehir;
    String kullaniciIlce;
    String kullaniciSemt;
    String kullaniciAdres;
    String pastaneAdi;
    String urunAdi;
    String urunDetay;
    Double urunFiyat;
    public String getPastaneAdi() {
        return pastaneAdi;
    }

    public void setPastaneAdi(String pastaneAdi) {
        this.pastaneAdi = pastaneAdi;
    }
    public UUID getSiparisNo() {
        return siparisNo;
    }

    public void setSiparisNo(UUID siparisNo) {
        this.siparisNo = siparisNo;
    }

    public String getKullaniciIlce() {
        return kullaniciIlce;
    }

    public void setKullaniciIlce(String kullaniciIlce) {
        this.kullaniciIlce = kullaniciIlce;
    }

    public String getKullaniciSemt() {
        return kullaniciSemt;
    }

    public void setKullaniciSemt(String kullaniciSemt) {
        this.kullaniciSemt = kullaniciSemt;
    }

    public String getKullaniciAdres() {
        return kullaniciAdres;
    }

    public void setKullaniciAdres(String kullaniciAdres) {
        this.kullaniciAdres = kullaniciAdres;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunDetay() {
        return urunDetay;
    }

    public void setUrunDetay(String urunDetay) {
        this.urunDetay = urunDetay;
    }

    public Double getUrunFiyat() {
        return urunFiyat;
    }

    public void setUrunFiyat(Double urunFiyat) {
        this.urunFiyat = urunFiyat;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSoyad() {
        return kullaniciSoyad;
    }

    public void setKullaniciSoyad(String kullaniciSoyad) {
        this.kullaniciSoyad = kullaniciSoyad;
    }

    public String getKullaniciTelefonNumarasi() {
        return kullaniciTelefonNumarasi;
    }

    public void setKullaniciTelefonNumarasi(String kullaniciTelefonNumarasi) {
        this.kullaniciTelefonNumarasi = kullaniciTelefonNumarasi;
    }

    public String getKullaniciSehir() {
        return kullaniciSehir;
    }

    public void setKullaniciSehir(String kullaniciSehir) {
        this.kullaniciSehir = kullaniciSehir;
    }

}
