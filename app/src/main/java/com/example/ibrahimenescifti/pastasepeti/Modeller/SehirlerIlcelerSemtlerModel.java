package com.example.ibrahimenescifti.pastasepeti.Modeller;

public class SehirlerIlcelerSemtlerModel {
    int SehirId;
    String SehirAdi;
    int ilceId;
    String IlceAdi;
    String MahalleAdi;
    String SemtAdi;

    public SehirlerIlcelerSemtlerModel(String IlceAdi, int IlceId)
    {
        this.IlceAdi=IlceAdi;
this.ilceId=IlceId;
    }
    public int getSehirId() {
        return SehirId;
    }

    public void setSehirId(int sehirId) {
        SehirId = sehirId;
    }

    public String getSehirAdi() {
        return SehirAdi;
    }

    public void setSehirAdi(String sehirAdi) {
        SehirAdi = sehirAdi;
    }

    public int getIlceId() {
        return ilceId;
    }

    public void setIlceId(int ilceId) {
        this.ilceId = ilceId;
    }

    public String getIlceAdi() {
        return IlceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        IlceAdi = ilceAdi;
    }

    public String getMahalleAdi() {
        return MahalleAdi;
    }

    public void setMahalleAdi(String mahalleAdi) {
        MahalleAdi = mahalleAdi;
    }

    public String getSemtAdi() {
        return SemtAdi;
    }

    public void setSemtAdi(String semtAdi) {
        SemtAdi = semtAdi;
    }
    @Override
    public String toString()
    {
        return getIlceAdi();
    }
}
