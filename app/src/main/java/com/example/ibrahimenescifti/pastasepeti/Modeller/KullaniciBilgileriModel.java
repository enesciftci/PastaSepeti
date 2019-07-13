package com.example.ibrahimenescifti.pastasepeti.Modeller;

import java.util.UUID;

public class KullaniciBilgileriModel {
    UUID KullaniciId;
    String Ad;
    String Soyad;
    String Mail;
    String Telefon;
    String GırısDurumu;
    String Sehir;
    String Ilce;
    String Semt;
    String Sifre;
    public UUID getKullaniciId() {
        return KullaniciId;
    }

    public void setKullaniciId(UUID kullaniciId) {
        KullaniciId = kullaniciId;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getSehir() {
        return Sehir;
    }

    public void setSehir(String sehir) {
        Sehir = sehir;
    }

    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String ilce) {
        Ilce = ilce;
    }

    public String getSemt() {
        return Semt;
    }

    public void setSemt(String semt) {
        Semt = semt;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }


    public String getGırısDurumu() {
        return GırısDurumu;
    }

    public void setGırısDurumu(String gırısDurumu) {
        GırısDurumu = gırısDurumu;
    }


}
