package com.example.ibrahimenescifti.pastasepeti.Modeller;

import java.util.Date;
import java.util.UUID;

public class SiparisBilgileriModel {
    UUID siparisNo;
    UUID pastaneId;
    UUID kullaniciId;
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
    String siparisNotu;
    Double urunFiyat;
    Date siparisTarihi;
    String odemeTuru;
    boolean durum;
    int urunAdet;
int siparisId;

    public int getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(int siparisId) {
        this.siparisId = siparisId;
    }

    public String getOdemeTuru() {
        return odemeTuru;
    }

    public void setOdemeTuru(String odemeTuru) {
        this.odemeTuru = odemeTuru;
    }
    public UUID getPastaneId() {
        return pastaneId;
    }

    public void setPastaneId(UUID pastaneId) {
        this.pastaneId = pastaneId;
    }

    public UUID getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(UUID kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getSiparisNotu() {
        return siparisNotu;
    }

    public void setSiparisNotu(String siparisNotu) {
        this.siparisNotu = siparisNotu;
    }
    public Date getSiparisTarihi() {
        return siparisTarihi;
    }

    public void setSiparisTarihi(Date siparisTarihi) {
        this.siparisTarihi = siparisTarihi;
    }

    public boolean isDurum() {
        return durum;
    }

    public void setDurum(boolean durum) {
        this.durum = durum;
    }

    public int getUrunAdet() {
        return urunAdet;
    }

    public void setUrunAdet(int urunAdet) {
        this.urunAdet = urunAdet;
    }

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
